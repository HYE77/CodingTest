import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken()); // T분 동안 음식 먹음
            int N = Integer.parseInt(st.nextToken()); // 음식 종류
            int D = Integer.parseInt(st.nextToken()); // 다이어트 효과 유지 시간
            int K = Integer.parseInt(st.nextToken()); // 몇 잔?

            int[] time = new int[N];
            int[] next = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
            	time[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(time);
            int[] cnt = new int[N];
            int j = 0;
            for (int i = 0; i < N; i++) {
                while (j < N && time[j] <= time[i] + D - 1) j++;
                cnt[i] = j - i;
                next[i] = j - 1;
            }
            
            int[][] dp = new int[K+1][N+1];
            
            for (int r = 1; r <= K; r++) {
            	for (int c = N-1; c >= 0; c--) {
            		int no = dp[r][c+1];
            		int yes = cnt[c] +  dp[r-1][next[c]+1];
            		dp[r][c] = Math.max(no, yes);
            	}
            }            

            System.out.println(dp[K][0]);
            br.close();
        }
}
