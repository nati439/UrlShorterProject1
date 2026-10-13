
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class UrlRepository {
	


	    private static final String URL = "jdbc:mysql://localhost:3306/nati";
	    private static final String USER = "nati";
	    private static final String PASSWORD = "nati123";
	 
	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	
//	    public void receiveUrl(ShortUrl hashmaP) throws SQLException{
//	    	
//	    }
}