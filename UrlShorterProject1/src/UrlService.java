import java.util.HashMap;
import java.util.Random;
public class UrlService {
	private HashMap<String, ShortUrl> urls = new HashMap<>();	
	//String --> is the key
	//ShortUrl --> is the value
	//"a7K2x"  →  [ shortCode = "a7K2x", longUrl = "https://youtube.com" ]
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
	public String shorten(String longurls) {
		//this method should just call random no logic.
		int size = 0;
		String rand = "";
		while(size < 3) {
			rand += random.nextInt(8);
			rand += String.valueOf((char) ('a' + random.nextInt(26)));	
			rand += String.valueOf((char) ('A' + random.nextInt(26)));
			size++;
		}

		//send to hashmap both longurl and short url 
		//Return shorturl
	}
}


