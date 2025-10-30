import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine());
        String[] nums = new String[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = st.nextToken();
        }
        
        // DP
        // i~j가 팰린드롬인가? = dp[i][j] = dp[i+1][j-1] == 1 && dp[i] == dp[j] ? 1 : 0;
        int[][] dp = new int[N][N];
        
        // 초기 세팅 (길이 1)
        for (int i = 0; i < N; i++) { 
        	dp[i][i] = 1;
        }
        
        // 길이가 2인 경우
        for (int i = 0; i < N-1; i++) {
        	if (nums[i].equals(nums[i+1])) dp[i][i+1] = 1;
        }
        
        // 나머지 채우기
        for (int len = 2; len < N; len++) { // i-j 차이
            for (int i = 0; i + len < N; i++) { // 시작점
                int j = i + len;
                if (nums[i].equals(nums[j]) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }
        
        // 출력
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            
            sb.append(dp[from][to]).append('\n');
        }
        
        System.out.println(sb.toString());
        br.close();
    }
}