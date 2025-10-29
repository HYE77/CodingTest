import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, sum;
	static int[] parent;
	static class Edge implements Comparable<Edge>{
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
        
        N = Integer.parseInt(st.nextToken()); // 집의 개수
        M = Integer.parseInt(st.nextToken()); // 길의 개수
        
        parent = new int[N+1];
        for (int i = 1; i < N+1; i++) {
        	parent[i] = i;
        }
        
        List<Edge> lst = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	lst.add(new Edge(from, to, cost));
        }
        
        Collections.sort(lst);
        
        int idx = 0;
        int pick = 0;
        while (pick < N-2) {
        	
        	Edge cur = lst.get(idx);
        	idx++;
        	
        	int p1 = findParent(cur.from);
        	int p2 = findParent(cur.to);
        	
        	if (p1 == p2) continue;
        	
        	// 다른 집합이면 합쳐주고 가중치 더하기
        	parent[p1] = p2;
        	sum += cur.cost;
        	pick++;
        }
        
        System.out.println(sum);
        br.close();
    }
    
    static int findParent(int n) {
    	if (parent[n] != n) parent[n] = findParent(parent[n]);
    	return parent[n];
    }
}

