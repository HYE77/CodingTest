import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int total = 0;
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
            total += values[i];
        }
        
        // dp 배열 선언
        // dp[i][j] = true --> A의 무게가 i이고, B의 무게가 j인 경우를 만들 수 있다
        boolean[][] dp = new boolean[total+1][total+1];
        dp[0][0] = true;
        
        int curSum = 0;
        for (int i = 0; i < N; i++) {
        	curSum += values[i];
        	// 현재까지 버거 가치의 합은 curSum
        	// 그 이하를 돌면서 작은 값으로 합 맞추기가 가능했던 이전 배낭들을 찾아가자
        	for (int a = curSum; a >= 0; a--) { // A 버거 합
        		for (int b = curSum; b >= 0; b--) { // B 버거 합
        			if (dp[a][b]) {
        				dp[a+values[i]][b] = true; // A에게 주는 경우
        				dp[a][b+values[i]] = true; // B에게 주는 경우
        			}
        		}
        	}
        }
        
        // 최적해 찾기
        int ans = 0;
        for (int i = 0; i < total+1; i++) {
        	for (int j = 0; j < total+1; j++) {
        		if (dp[i][j]) {
        			
        			int curMin = Math.min(total-i-j, Math.min(i, j)); // 세 개의 가치 중 가장 작은 가치 (우리가 찾고자 하는 가장 작은 배낭의 가치)
        			ans = Math.max(curMin, ans);
        		}
        	}
        }

        System.out.println(ans);
        br.close();
    }
}