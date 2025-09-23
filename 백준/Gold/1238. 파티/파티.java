import java.util.*;
import java.io.*;

public class Main {
	
	static int N, X, M;
	static int[] dist;
	static boolean[] visited;
	static List<Edge>[] adj;
	
	static class Edge implements Comparable<Edge>{
		int to, dist;

		public Edge(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수 (마을 수)
		M = Integer.parseInt(st.nextToken()); // 단방향 도로 수
		X = Integer.parseInt(st.nextToken()); // 파티가 열리는 마을
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[N+1];
		adj = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			adj[from].add(new Edge(to, dist));
		}
		
		int[] totalTime = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			if (i == X) continue;
			dijkstra(i);
			totalTime[i] += dist[X];
			dijkstra(X);
			totalTime[i] += dist[i];
		}
		
		int maxValue = -1;
		for (int n : totalTime) {
			maxValue = Math.max(maxValue, n);
		}
		
		bw.write(maxValue+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void dijkstra(int start) {
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[N+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			
			Edge curr = pq.poll();
			
			if (visited[curr.to]) continue;
			visited[curr.to] = true;
			
			for (Edge e : adj[curr.to]) {
				if (!visited[e.to] && dist[e.to] > dist[curr.to] + e.dist ) {
					dist[e.to] = dist[curr.to] + e.dist;
					pq.add(new Edge(e.to, dist[e.to]));
				}
			}
			
		}
	}
	
}
