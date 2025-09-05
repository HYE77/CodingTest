
import java.util.*;
import java.io.*;

public class Solution {
	
	static int[] fare; // 이용 요금 (1일, 1개월, 3개월, 1년)
	static int[] days = new int[13]; // 이용 계획
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			// 요금 입력받기
			st = new StringTokenizer(br.readLine());
			fare = new int[4];
			for (int f = 0; f < 4; f++) {
				fare[f] = Integer.parseInt(st.nextToken());
			}
			
			// 이용 계획 입력받기
			st = new StringTokenizer(br.readLine());
			for (int d = 1; d <= 12; d++) {
				days[d] = Integer.parseInt(st.nextToken());
			}
			
			// 최소금액 찾기
			answer = Integer.MAX_VALUE;
			dfs(1, 0);
			answer = Math.min(answer, fare[3]); // 1년권과 비교
			
			// 결과 출력
			bw.write("#" + t + " " + answer + "\n");
			
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static void dfs(int month, int totalFare) {
		// 12개월 다 돌았으면 최솟값 저장하고 리턴
		if (month > 12) { 
			answer = Math.min(answer,  totalFare);
			return;
		}
		
		// 시작하는 달 기준으로 1일권 or 1개월권 or 3개월권
		// 1일권
		totalFare += fare[0] * days[month];
		dfs(month+1, totalFare);
		totalFare -= fare[0] * days[month];
		
		// 1개월권
		totalFare += fare[1];
		dfs(month+1, totalFare);
		totalFare -= fare[1];
		
		// 3개월권
		totalFare += fare[2];
		dfs(month+3, totalFare);
		totalFare -= fare[2];
		

	}


}

