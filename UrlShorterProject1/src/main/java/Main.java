import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.sql.SQLException;
public class Main {
	public static void main(String[] args) throws SQLException{
		
		//Scanner
		Scanner scanner = new Scanner(System.in);
		
		UrlService us = new UrlService();

		

		//while loop and exit
		while(true) {
			//ask
			System.out.println("1. Shorten 2. Resolve 3. Exit");
			String qna = scanner.nextLine();
			
			if (qna.equals("1")) {
				System.out.println("LONG URL: ");
				String shortens = scanner.nextLine();
				System.out.println(us.shorten(shortens));
			}else if(qna.equals("2")) {
				System.out.println("Short url: ");
				String resolves = scanner.nextLine();
				System.out.println(us.resolve(resolves));
			}else if(qna.equals("3")) {
				break;
			}else {
				System.out.println("1 2 or 3 NOTHING ELSE");
			}
			
		}
		
	}
	
	
}
