import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
    	 2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
    	 3. 판매는 얼마든지 할 수 있다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			int days = Integer.parseInt(br.readLine()); // 며칠?
			long[] prices = new long[days]; // 매매가 배열
			
			st = new StringTokenizer(br.readLine());
			for (int d = 0; d < days; d++) {
				prices[d] = Long.parseLong(st.nextToken());
			}
			
			
			// 계산하기
			long ans = 0;
			long currMax = prices[days-1];
			for (int i = days-2; i >= 0; i--) { //뒤에서부터 확인
				if (prices[i] < currMax) {
					ans += (currMax - prices[i]);
				}
				currMax = Math.max(currMax, prices[i]); // 최댓값 확인
				
			}
			
			System.out.println("#" + t + " " + ans);
			
			
		}
	}

}
