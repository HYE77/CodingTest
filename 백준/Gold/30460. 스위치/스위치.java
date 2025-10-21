import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] original = new int[N+1];
        int[] doubled = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
        	original[i] = Integer.parseInt(st.nextToken());
        	doubled[i] = original[i] * 2;
        }
        
        
        int[][] dp = new int[N+1][4];
        
        Arrays.fill(dp[0], -10000);
        
        dp[1][0] = original[1];
        dp[1][1] = doubled[1];
        dp[1][2] = -10000;
        dp[1][3] = -10000;
     
        for (int i = 2; i <= N; i++) {
        	
        	dp[i][0] = Math.max(dp[i-1][0], dp[i-1][3]) + original[i];
        	dp[i][1] = Math.max(dp[i-1][0], dp[i-1][3])+ doubled[i];
        	dp[i][2] = dp[i-1][1] + doubled[i];
        	dp[i][3] = dp[i-1][2] + doubled[i];
        }
        
        int ans = Integer.MIN_VALUE;
        for (int n : dp[N]) ans = Math.max(ans, n);
        System.out.println(ans);

        br.close();
    }
}