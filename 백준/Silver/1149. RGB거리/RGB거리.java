import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][3];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 3; j++) {
        		rgb[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int[][] dp = new int[N][3];
        
        for (int c = 0; c < 3; c++) {
        	dp[0][c] = rgb[0][c];
        }
        
        for (int r = 1; r < N; r++) {
        	dp[r][0] = Math.min(dp[r-1][1], dp[r-1][2]) + rgb[r][0];
        	dp[r][1] = Math.min(dp[r-1][0], dp[r-1][2]) + rgb[r][1];
        	dp[r][2] = Math.min(dp[r-1][0], dp[r-1][1]) + rgb[r][2];
        }
        
        int ans = Math.min(dp[N-1][2], Math.min(dp[N-1][0], dp[N-1][1]));
        
        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
