import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        int[] nums1 = new int[N];
        int[] nums2 = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	nums1[i] = Integer.parseInt(st.nextToken());
        	nums2[i] = nums1[i];
        }
        
        int target = Integer.parseInt(br.readLine());
        
        Arrays.sort(nums2);
        
        int ans = 0;
        
        for (int i = 0; i < N; i++) {
        	
        	int left = 0;
        	int right = N-1;
        	
        	while (left <= right) {
        		
        		int mid = (left + right) / 2;
        		
        		if (nums2[mid] + nums1[i] == target) {
        			if (nums2[mid] != nums1[i]) ans++;
        			break;
        		}
        		
        		if (nums2[mid] + nums1[i] > target) right = mid - 1;
        		else if (nums2[mid] + nums1[i] < target) left = mid + 1;
        	}
        }
        
        System.out.println(ans/2);
        br.close();
    }
}
