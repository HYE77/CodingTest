import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;
	
	static class Edge implements Comparable<Edge> {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        parent = new int[V+1];
        for (int i = 0; i <= V; i++) {
        	parent[i] = i;
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        for (int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	pq.add(new Edge(from, to, cost));
        }
        
        int edgeCnt = 0;
        int sum = 0;
        
        while (edgeCnt < V-1) {
        	
        	Edge cur = pq.poll();
        	
        	int px = findSet(cur.from);
        	int py = findSet(cur.to);
        	
        	if (px == py) continue;
        	
        	edgeCnt++;
        	sum += cur.cost; 
        	parent[px]= py; 
        }
        
        System.out.println(sum);

        br.close();
    }
    
    static int findSet(int x) {
    	
    	if (x != parent[x]) parent[x] = findSet(parent[x]);
    	return parent[x];
    	
    }
}