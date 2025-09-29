import java.util.*;
import java.io.*;

public class Main {
	
	static StringBuilder sb;
	static int N, M;
	static int[] selected;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 1~N까지의 수를
        M = Integer.parseInt(st.nextToken());  // 중복없이 M개
        
        selected = new int[M];
        visited = new boolean[N+1];
        perm(0);
       
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void perm(int sIdx) {
    	if (sIdx == M) {
    		for (int n : selected) {
    			sb.append(n).append(" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		if (visited[i]) continue;
    		
    		selected[sIdx] = i;
    		visited[i] = true;
    		perm(sIdx+1);
    		visited[i] = false;
    	}
    }
}
