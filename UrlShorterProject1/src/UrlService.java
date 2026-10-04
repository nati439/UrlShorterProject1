import java.util.HashMap;
public class UrlService {
	private HashMap<String, ShortUrl> urls = new HashMap<>();	
	//String --> is the key
	//ShortUrl --> is the value
	ShortUrl su = new ShortUrl();
	private String theurlshort = su.geturl();
	private String theurlItself = su.geturlItself();
	
}
