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
		String logic1 = logic();
		//add logic1 into urls
		//return the logic1
		ShortUrl su = new ShortUrl(longurls, logic1);
		urls.put(logic1, su);
		return logic1;
	}
}


