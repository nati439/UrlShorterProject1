import java.sql.SQLException;
import java.util.Random;
public class UrlService {

	private Random random = new Random();
	//The generator is an object that can produce random numbers when you ask it.
	private final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public String logic () {
		String ans = "";
		int size = 0;
		while(size < 7) {
			int i = random.nextInt(CHARS.length());
			ans += CHARS.charAt(i);
			size ++;
		}
		
		return ans;
		
	}
	
	public String shorten(String longurls) throws SQLException {
	    UrlRepository ur = new UrlRepository();
	    ShortUrl su = new ShortUrl(longurls, logic());

	    while (!ur.receiveUrl(su)) {
	        su = new ShortUrl(longurls, logic());
	    }

	    return su.geturlshort();
	}
	
	//resolve() take short url and give up long one.
	
	public String resolve(String shorturls) throws SQLException{
		UrlRepository ur = new UrlRepository();
		String store = ur.sendUrl(shorturls);
		if (store.equals("This short url not valid")) {
			return "Must shorten first";
		}
		return store;
	}
	
	
	
}


