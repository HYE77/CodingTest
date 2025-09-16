import java.util.*;
import java.io.*;
 
public class Solution {
	
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int[] dp = new int[10000];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < 10000; i++) {
        	dp[i] = dp[i-1] + dp[i-2];
        }
        
        
        
        for (int i = 0; i < 5; i++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	bw.write(dp[n] + "\n");
        }
        
        
 
        
        bw.flush();
        br.close();
        bw.close();
         
    }
    

}