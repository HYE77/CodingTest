import java.util.*;
import java.io.*;

public class Main {

	static int N, Q;
	static List<int[]>[] adj;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 동영생 개수
		Q = Integer.parseInt(st.nextToken()); // 쿼리 개수
		
		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			adj[from].add(new int[] {to, dist});
			adj[to].add(new int[] {from, dist});
		}
		
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken()); // 유사도 하한
			int v = Integer.parseInt(st.nextToken()); // 현재 보고있는 동영상
			
			int ans = bfs(k, v);
			sb.append(ans).append('\n');
		}		
		
		System.out.println(sb.toString());
		br.close();
	}
	
	
	static int bfs(int k, int v) {
		
		Arrays.fill(visited, false);
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {v, Integer.MAX_VALUE});
		visited[v] = true;
		
		while (!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			for (int[] neighbor : adj[cur[0]]) { // neighbor : {도착지, 유사도}
				
				if (visited[neighbor[0]]) continue;
				
				int d = Math.min(cur[1], neighbor[1]);
				if (d < k) continue;
				
				q.add(new int[] {neighbor[0], d});
				visited[neighbor[0]] = true;		
				
			}
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i]) cnt++;
		}
		
		return cnt-1;
		
	}
}
