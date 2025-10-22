import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] grid = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // check
        int total = 0;
        for (int n : arr) total += n;
        if (total < S) System.out.println(0);
        
        else {
	        // start
	        int minLen = N;
	        int left = 0;
	        int right = 1;
	        int sum = arr[0];
	        
	        while (left < N) {
	        	
	        	if (sum >= S) minLen = Math.min(minLen, right-left);
	        	
	        	if (sum <= S && right < N) {
	        		right++;
	        		if (right <= N) sum += arr[right-1];
	        	} else {
	        		sum -= arr[left];
	        		left++;
	        	}
	        }
            
	        System.out.println(minLen);
        }
    }   
}
