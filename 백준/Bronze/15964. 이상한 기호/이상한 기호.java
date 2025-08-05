import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		
		long B = sc.nextLong();
		
		System.out.println(cal(A, B));
		
		sc.close();

	}
	
	public static long cal(long A, long B) {
		long ans = (A+B)*(A-B);
		return ans;
	}

}
