import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.io.OutputStream;
import java.io.IOException;
import java.sql.SQLException;
public class RedirectHandler{
    public static void register(HttpServer server) {
        server.createContext("/", exchange -> {
        	 if (!exchange.getRequestMethod().equals("GET")) {
	                exchange.sendResponseHeaders(405, -1);
	                exchange.close();
	                return;
	            }
        	 String path = exchange.getRequestURI().getPath();
        	 String code = path.substring(1);

        	 UrlService us = new UrlService();
        	

             try {
                 String longurl = us.resolve(code);

                 byte[] bytes = longurl.getBytes(StandardCharsets.UTF_8);


                 try (OutputStream output = exchange.getResponseBody()) {
                     output.write(bytes);
                 }
                 exchange.getResponseHeaders().set("Location", longurl);
                 exchange.sendResponseHeaders(302, -1);
                 exchange.close();
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
             
        });
    }
}
