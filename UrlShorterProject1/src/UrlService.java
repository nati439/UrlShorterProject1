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
		while (urls.containsKey(logic1)) {
			logic1 = logic();
		}
		
		ShortUrl su = new ShortUrl(longurls, logic1);
		urls.put(logic1, su);
		return logic1;
	}
	
	//resolve() take short url and give up long one.
	
	public String resolve(String shorturls) {
		if (urls.containsKey(shorturls)) {
			ShortUrl x =  urls.get(shorturls);
			return(x.geturllong());
		}
		return "Must shorten first";
	}
}


