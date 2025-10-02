import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] selected, nums;
	static Set<String> set;
	static StringBuilder sb, ansSb;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // N개의 수 중
        M = Integer.parseInt(st.nextToken()); // M개 뽑기
        selected = new int[M];
        nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        ansSb = new StringBuilder();
        set = new HashSet<>();
        Arrays.sort(nums);
        solve(0);
        
        bw.write(ansSb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void solve(int sIdx) {
    	
    	if (sIdx == M) {
    		sb = new StringBuilder();
    		for (int num : selected) {
    			sb.append(num).append(' ');
    		}
    		sb.append('\n');
    		if (!set.contains(sb.toString())) {
    			set.add(sb.toString());
    			ansSb.append(sb.toString());
    		} 
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
    		if (sIdx == 0 || nums[i] >= selected[sIdx-1]) {
    			selected[sIdx] = nums[i];
    			solve(sIdx + 1);
    		}
    	}
    }
}
