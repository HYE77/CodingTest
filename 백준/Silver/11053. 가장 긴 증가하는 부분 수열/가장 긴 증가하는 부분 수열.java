import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N];
        int ans = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) { // 현재 채울 인덱스
        	for (int j = 0; j < i; j++) { // 비교할 앞쪽 인덱스
        		if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
        	}
        	ans = Math.max(ans, dp[i]);
        }
        
        bw.write(ans+"");
        
        bw.flush();
        br.close();
        bw.close();
    }
}
