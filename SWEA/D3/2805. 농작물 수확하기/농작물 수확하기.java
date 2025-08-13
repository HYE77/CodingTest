import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] farm = new int[N][N];
			
			// 농장 만들기
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = Integer.parseInt(str.charAt(j) + "");
				}
			}
			

			// 수확량 구하기
			int sum = 0;
			for (int r = 0; r < N; r++) {
				if (r < N/2) {
					for (int c = N/2 - r; c <= N/2 + r; c++) {
						sum += farm[r][c];
					}
				}
				
				else if (r == N/2) {
					for (int c = 0; c < N; c++) {
						sum += farm[r][c];
					}
				}
				
				else {
					for (int c = N/2 - (N-1-r); c <=  N/2 + (N-1-r); c++) {
						sum += farm[r][c];
					}
					
				}
			}
			
			
			System.out.println("#" + t + " " + sum);
			
		}

		br.close();

	}

}
