import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.io.OutputStream;
import java.io.IOException;
import java.sql.SQLException;

public class https {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8080), 0
        );

        server.createContext("/shorten", exchange -> {
        RedirectHandler.register(server);	
            // Only allow POST requests
            if (!exchange.getRequestMethod().equals("POST")) {
                exchange.sendResponseHeaders(405, -1);
                exchange.close();
                return;
            }

            // Read the request body
            String body;

            try (var input = exchange.getRequestBody()) {
                body = new String(
                    input.readAllBytes(),
                    StandardCharsets.UTF_8
                );
            }

            // Validate the input
            if (body.isBlank()) {
                byte[] bytes = "URL cannot be empty"
                    .getBytes(StandardCharsets.UTF_8);

                exchange.sendResponseHeaders(400, bytes.length);

                try (OutputStream output = exchange.getResponseBody()) {
                    output.write(bytes);
                }

                exchange.close();
                return;
            }

            // Shorten the URL
            UrlService us = new UrlService();

            try {
                String shortCode = us.shorten(body);

                byte[] bytes = shortCode.getBytes(StandardCharsets.UTF_8);

                exchange.sendResponseHeaders(200, bytes.length);

                try (OutputStream output = exchange.getResponseBody()) {
                    output.write(bytes);
                }

            } catch (SQLException e) {
                // Log the actual database error
                e.printStackTrace();

                // Send an error response to the client
                byte[] bytes = "Database error"
                    .getBytes(StandardCharsets.UTF_8);

                exchange.sendResponseHeaders(500, bytes.length);

                try (OutputStream output = exchange.getResponseBody()) {
                    output.write(bytes);
                }
            }

            exchange.close();
        });

        server.start();

        System.out.println("Server running on port 8080");
    }
}