import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //  바구니 개수
		int M = sc.nextInt(); // 공 넣는 횟수
		
		int[] baskets = new int[N+1];
		
		for (int m = 1; m <= M; m++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			
			for (int a = i; a <= j; a++) {
				baskets[a] = k;
			}
		}
		baskets = Arrays.copyOfRange(baskets, 1, N+1);
		for (int num : baskets) {
			System.out.print(num + " ");
		}
		

		sc.close();
 	}

}