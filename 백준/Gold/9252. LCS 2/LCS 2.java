import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        
        int[][] dp = new int[str1.length+1][str2.length+1];
        
        // dp 배열 만들기
        for (int i = 1; i < str1.length+1; i++) {
        	for (int j = 1; j < str2.length+1; j++) {
        		if (str1[i-1] == str2[j-1]) {
        			dp[i][j] = dp[i-1][j-1] + 1; 
        			/// 
        		}
        		else dp[i][j] = Math.max(dp[i-1][j],  dp[i][j-1]);
        	}
        }
        
        // back trace
        int i = str1.length;
        int j = str2.length;
        
        while (dp[i][j] > 0) {
        	
        	if (str1[i-1] == str2[j-1]) {
        		sb.append(str1[i-1]);
        		i--;
        		j--;
        	} else if (dp[i-1][j] > dp[i][j-1]) i--;
        	else j--;
        }
        
        sb.reverse();
        
        System.out.println(dp[str1.length][str2.length]);
        System.out.println(sb.toString());
        
    }
}
