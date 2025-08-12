import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //  바구니 개수
		int[] arr = new int[N+1];
		
		for (int i = 0; i <= N; i++) arr[i] = i;
		int[] original = Arrays.copyOf(arr,  N+1);
		
		int M = sc.nextInt(); // 뒤집는 횟수
		
		for (int k = 0; k < M; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			for (int idx = i; idx <= j; idx++) {
				arr[idx] = original[i+j-idx];
			}
			original = Arrays.copyOf(arr, N+1);
			
		}
		
		int[] ans = Arrays.copyOfRange(arr, 1, N+1);
		
		for (int num : ans) {
			System.out.print(num + " ");
		}
		
		
		sc.close();
 	}

}