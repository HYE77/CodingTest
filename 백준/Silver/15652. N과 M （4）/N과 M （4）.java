import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 1~N의 수를
        M = Integer.parseInt(st.nextToken()); // M개
        selected = new int[M];
        
        solve(0, 1);
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void solve(int sIdx, int n) {
    	
    	if (sIdx == M) {
    		for (int num : selected) {
    			sb.append(num).append(' ');
    		}
    		sb.append('\n');
    		return;
    	}
    	
    	for (int i = n; i <= N; i++) {
    		selected[sIdx] = i;
    		solve(sIdx + 1, i);
    	}
    }
}
