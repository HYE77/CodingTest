import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int ans = power(N, M);
			
			// N의 M승 구하기
			System.out.println("#" + tc + " " + ans);
			
		}
		
		sc.close();
	}
	
	
	public static int power(int N, int M) {
		if (M == 1) {
			return N*1;
		}
		return power(N, M-1) * N;
	}
}
