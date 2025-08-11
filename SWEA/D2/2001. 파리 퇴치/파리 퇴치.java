import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 배열 크기
			int M = sc.nextInt(); // 파리채 크기
			
			int[][] arr = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			int max = 0;
			for (int i = 0; i < N-M+1; i++) {
				for (int j = 0; j < N-M+1; j++) {
					int sum = 0;
					for (int x = i; x < i+M; x++) {
						for (int y = j; y < j+M; y++) {
							sum += arr[x][y];
						}
					}
					if (sum > max) max = sum;
				}
			}
			
			System.out.println("#" + t + " " + max);
				
			
		}
		
		sc.close();

	}

}
