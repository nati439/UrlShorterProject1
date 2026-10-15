import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
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
	
	public void writeToFile() throws IOException {
	    FileWriter writer = new FileWriter("urls.txt");
	    for (ShortUrl i : urls.values()) {
	        writer.write(i.geturlshort() + " " + i.geturllong() + "\n");
	    }
	    writer.close();
	}
	
	public void readToFile() throws IOException{
		try {
			BufferedReader reader = new BufferedReader(new FileReader("urls.txt"));

			String line;
			while((line = reader.readLine()) != null) {
				String[] lists = line.split(" ");
				urls.put(lists[0], new ShortUrl(lists[1], lists[0]));
			}
		reader.close();
		}catch(FileNotFoundException e) {
			
		}
		
		
	}
	
}


