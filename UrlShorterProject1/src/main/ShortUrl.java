//ShortUrl is small and could be skipped. It pays off later, when each URL gets more data like clicks and timestamps.

import java.util.HashMap;

public class ShortUrl {
	private String urlLong;
	private String urlshort;
	
	public ShortUrl(String urlLong,String urlshort) {
		this.urlLong = urlLong;
		this.urlshort = urlshort;
	}
	
	public String geturllong() {
		return this.urlLong;
	}
	
	public String geturlshort() {
		return this.urlshort;
	}
}
