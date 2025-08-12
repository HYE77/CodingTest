import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //  바구니 개수
		int[] arr = new int[N+1];
		for (int i = 0; i <= N; i++) arr[i] = i;
		
		int M = sc.nextInt(); // 바꾸는 횟수
		
		for (int k = 0; k < M; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			
		}
		
		int[] ans = Arrays.copyOfRange(arr, 1, N+1);
		
		for (int num : ans) {
			System.out.print(num + " ");
		}
		
		
		sc.close();
 	}

}