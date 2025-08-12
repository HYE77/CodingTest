import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int totalSum = sc.nextInt();
		
		int cnt = sc.nextInt();
		
		int checkSum = 0;
		
		for (int c = 0; c < cnt; c++) {
			int cost = sc.nextInt();
			int tmp = sc.nextInt();
			checkSum += cost * tmp;
		}
		
		if (checkSum == totalSum) System.out.println("Yes");
		else System.out.println("No");
		sc.close();
 	}

}