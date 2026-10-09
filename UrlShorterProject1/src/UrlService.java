import java.util.HashMap;
import java.util.Random;
public class UrlService {
	private HashMap<String, ShortUrl> urls = new HashMap<>();	
	//String --> is the key
	//ShortUrl --> is the value
	//"a7K2x"  →  [ shortCode = "a7K2x", longUrl = "https://youtube.com" ]
	private Random random = new Random();
	
}


