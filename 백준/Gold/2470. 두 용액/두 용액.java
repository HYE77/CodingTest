import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 산성 -> 양수
        // 알칼리성 -> 음수
        
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = N-1;
        long gap = Long.MAX_VALUE;
        long[] ans = new long[2];
        
        
        while (left < right) {
        	
        	long result = arr[left] + arr[right];
        	
        	if (Math.abs(result) < gap) {
        		gap = Math.abs(result);
        		ans[0] = arr[left];
        		ans[1] = arr[right];
        	}
        	
        	if (result == 0) break;
        	
        	if (Math.abs(arr[right]) > Math.abs(arr[left])) right--;
        	else left++;
        	
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(ans[0]).append(' ').append(ans[1]);
        
        System.out.println(sb.toString());

        br.close();
    }
}