import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	nums[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(nums);
        
        long num1 = -1;
        long num2 = -1;
        long num3 = -1;
        long gap = Long.MAX_VALUE;
        
        // 탐색
        for (int k = 1; k < N-1; k++) {
        	// k는 가운데 용액
        	
        	// 첫 번째 & 마지막 용액 이분탐색
        	int left = 0;
        	int right = N-1;
        	
        	while (left < k && k < right) {
        		
        		long tmp = nums[k] + nums[left] + nums[right];
        		
        		if (Math.abs(tmp) < gap) {
        			num1 = nums[left];
        			num2 = nums[k];
        			num3 = nums[right];
        			gap = Math.abs(tmp);
        		}
        		
        		if (tmp < 0) left++;
        		else right--;
        		
        	}
        }
        
        sb.append(num1).append(' ').append(num2).append(' ').append(num3);
        System.out.println(sb.toString());
        br.close();
    }
}