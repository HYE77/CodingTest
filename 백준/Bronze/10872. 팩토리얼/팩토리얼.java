import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		if (N == 0) {
			System.out.println(1);
		} else {
			int ans = 1;
			for (int i = 2; i <= N; i++) {
				ans *= i;
			}
			
			System.out.println(ans);
		}

		sc.close();
	}

}