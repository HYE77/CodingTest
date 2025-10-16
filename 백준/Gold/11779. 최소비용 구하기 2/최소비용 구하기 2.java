import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, A, B;
	static List<Edge>[] adj;
	static int[] dist;
	static boolean[] visited;
	static int[] prev;
	static int INF = 1_000_000_000;
	static class Edge implements Comparable<Edge> {
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
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine()); // 도시 개수
        m = Integer.parseInt(br.readLine()); // 버스 노선 개수
        
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
        	adj[i] = new ArrayList<>();
        }
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        
        prev = new int[n+1];
        visited = new boolean[n+1];
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int dist = Integer.parseInt(st.nextToken());
        	
        	adj[from].add(new Edge(to, dist));
        }
        
        st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        dijkstra(A);
        StringBuilder sb = new StringBuilder();
        sb.append(dist[B]).append('\n');
        
        List<Integer> route = new ArrayList<>();
        
        int curr = B;
        while (curr != A) {
        	route.add(curr);
        	curr = prev[curr];
        }
        route.add(curr);
        
        
        sb.append(route.size()).append('\n');
        for (int i = route.size() - 1; i >= 0; i--) sb.append(route.get(i)).append(' ');
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

	private static void dijkstra(int from) {
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(from, 0));
		dist[from] = 0;
		
		while (!pq.isEmpty()) {
			
			Edge curr = pq.poll();
			int now = curr.to;
			
			if (visited[curr.to]) continue;
			
			visited[curr.to]= true;

			for (Edge e : adj[curr.to]) {
				if (!visited[e.to] && dist[e.to] > dist[curr.to]+ e.dist) {
					dist[e.to] = dist[curr.to] + e.dist;
					prev[e.to] =  now;
					pq.add(new Edge(e.to, dist[e.to]));
				}
			}
		}
	}
}
