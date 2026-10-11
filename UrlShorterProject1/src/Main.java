import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		//Scanner
		Scanner scanner = new Scanner(System.in);
		
		//while loop and exit
		while(true) {
			//ask
			System.out.println("1. Shorten 2. Resolve 3. Exit");
			String qna = scanner.nextLine();
			System.out.println("LONG URL: ");
			String shortens = scanner.nextLine();

			if (qna == "1") {
				UrlService us = new UrlService();
				System.out.println(us.shorten(shortens));
		
			}
			
		}
		//1.resorve 2. shorten
		//2:
			//add there answer to class and return result. 
		//1. resortve
			//add there answer to class and return result. 
		
	}
}
