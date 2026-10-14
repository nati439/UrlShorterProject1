import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
public class UrlRepository {
	
		
		
	    private static final String URL = "jdbc:mysql://localhost:3306/nati";
	    private static final String USER = "nati";
	    private static final String PASSWORD = "nati123";
	 
	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
    	Connection conn = UrlRepository.getConnection();
    	// Ask UrlRepository to connect to MySQL and store the connection
    	// in the variable conn so we can use it to execute SQL commands
	    public boolean receiveUrl(ShortUrl su) throws SQLException{
	    	//main: query into database. 
	    	//create new object for shorturl
	    	String x = su.geturllong();
	    	String y = su.geturlshort();
	    	String sql1 = "SELECT short_url FROM url_storage WHERE short_url = ?";
	    	String sql = "INSERT INTO url_storage (long_url, short_url) VALUES (?, ?)";

	    	try (Connection conn = UrlRepository.getConnection()) {

	    	    try (PreparedStatement stmt1 = conn.prepareStatement(sql1)) {
	    	        stmt1.setString(1, y);

	    	        try (ResultSet rs = stmt1.executeQuery()) {
	    	            if (rs.next()) {
	    	                return false;
	    	            }
	    	        }
	    	    }

	    	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	    	        stmt.setString(1, x);
	    	        stmt.setString(2, y);
	    	        stmt.executeUpdate();
	    	        return true;
	    	    }
	    	}
	    }
	
	    	
	    	
	    
	    
	    //sendUrl from db to urlservice
}