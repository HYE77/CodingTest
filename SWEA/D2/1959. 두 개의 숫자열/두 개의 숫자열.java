import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int[] arr1 = new int[a];
			int[] arr2 = new int[b];
			
			for (int i = 0; i < a; i++) {
				arr1[i] = sc.nextInt();
			}
			
			for (int j = 0; j < b; j++) {
				arr2[j] = sc.nextInt();
			}
			
			if (a < b) { // a > b 하게 만들자
				int[] temp = Arrays.copyOf(arr1, a);
				arr1 = Arrays.copyOf(arr2, b);
				arr2 = temp;
				
				int tempInt = a;
				a = b;
				b = tempInt;
			}

			
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < a-b+1; i++ )  {
				int sum = 0;
				for (int j = 0; j < b; j++) {
					sum += arr2[j] * arr1[i+j];
				}
				if (sum > max) max = sum;
			}
			
			System.out.println("#" + t + " " + max);
		}
		
		sc.close();

	}

}