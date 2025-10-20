import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R, maxCnt;
	static final int INF = 1_000_000_000;
	static int[] items;
	static List<Edge>[] adj;
	static boolean[] visited;
	static int[] dist;
	
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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 지역 개수
        M = Integer.parseInt(st.nextToken()); // 수색 범위
        R = Integer.parseInt(st.nextToken()); // 길의 개수
        
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
        	adj[i] = new ArrayList<>();
        }
        
        items = new int[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        
        // 아이템 수
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	items[i] = Integer.parseInt(st.nextToken());
        }
        
        // 간선 정보 입력 받기
        for (int i = 0; i < R; i++) {
        	st = new StringTokenizer(br.readLine());
        	int to = Integer.parseInt(st.nextToken());
        	int from = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	adj[to].add(new Edge(from, cost));
        	adj[from].add(new Edge(to, cost));
        }
        
        // 각 좌표에 떨어지는 경우
        for (int pos = 1; pos <= N; pos++) {
        	Arrays.fill(visited, false);
        	Arrays.fill(dist, INF);
        	
        	dijkstra(pos);
        	
        	int tmp = 0;
        	for (int i = 1; i <= N; i++) {
        		if (dist[i] <= M) tmp += items[i];
        	}
        	
        	maxCnt = Math.max(maxCnt, tmp);
        }
        
        System.out.println(maxCnt);
        br.close();
    }
    
    static void dijkstra(int start) {
    	
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
    	dist[start] = 0;
    	pq.add(new Edge(start, 0));
    	
    	while (!pq.isEmpty()) {
    		Edge cur = pq.poll();
    		
    		if (visited[cur.to]) continue;
    		visited[cur.to] = true;
    		
    		for (Edge e : adj[cur.to]) {
    			if (!visited[e.to] && dist[e.to] > dist[cur.to]+ e.dist) {
    				dist[e.to] = dist[cur.to] + e.dist;
    				pq.add(new Edge(e.to, dist[e.to]));
    			}
    		}
    	}
    }
}
