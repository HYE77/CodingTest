import java.io.*;
import java.util.*;

public class Main {
	
	static int N, R, Q;
	static boolean[] visited;
	static int[] dp;
	static List<Integer>[] tree;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 트리 정점 수
        R = Integer.parseInt(st.nextToken()); // 루트 번호
        Q = Integer.parseInt(st.nextToken()); // 쿼리 수
        
        visited = new boolean[N+1];
        dp = new int[N+1];
        tree = new ArrayList[N+1];
        
        for (int i = 1; i <= N; i++) {
        	tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N-1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	tree[u].add(v);
        	tree[v].add(u);
        }
        
        // R을 정점으로 트리 구조 만들기
        makeTree(R);
        
        // 정답 출력
        for (int q = 0; q < Q; q++) {
        	int num = Integer.parseInt(br.readLine());
        	sb.append(dp[num]).append('\n');
        }
        
        System.out.println(sb.toString());
        br.close();
    }
    
    static void makeTree(int p) {
    	visited[p] = true;
    	dp[p] = 1;
    	
    	for (int c : tree[p]) {
    		if (!visited[c]) {
    			makeTree(c);
    			dp[p] += dp[c];
    		}
    	}
    }
}
