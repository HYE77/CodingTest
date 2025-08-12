import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int ans = num / 4;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ans; i++) {
			sb.append("long ");
		}
		
		sb.append("int");
		System.out.println(sb);
		sc.close();
 	}

}