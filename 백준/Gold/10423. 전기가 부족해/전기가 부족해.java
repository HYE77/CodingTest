import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static Set<Integer> power = new HashSet<>();
	static int[] parent;
	
	static class Edge implements Comparable<Edge> {
		int from, to, dist;

		public Edge(int from, int to, int dist) {
			this.from = from;
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 케이블 수
        K = Integer.parseInt(st.nextToken()); // 발전소 수

        // 발전소 정보 저장        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
        	power.add(Integer.parseInt(st.nextToken()));
        }
        
        // 간선 정보 저장
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int dist = Integer.parseInt(st.nextToken());
        	
        	pq.add(new Edge(from, to, dist));
        }
        
        // MST 만들기
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        
        long distSum = 0;
        
        while (!pq.isEmpty()) {
        	Edge e = pq.poll();
        	
        	int px = findParent(e.from);
        	int py = findParent(e.to);
        	
        	// 발전소 두 개를 연결한다면 건너뛰기
        	if (power.contains(px) && power.contains(py)) continue;
        	
        	// 이미 연결된 지역이라면 건너뛰기
        	if (px == py) continue;
        	
        	if (power.contains(px)) parent[py] = px;
        	else parent[px] = py;
        	
        	distSum += e.dist;
        	
        	// 모두 연결됐는지 확인
        	if (check()) break;
        }
       
        System.out.println(distSum);
        br.close();
    }
    
    static int findParent(int k) {
    	if (parent[k] != k) parent[k] = parent[parent[k]];
    	return parent[k];
    }
    
    static boolean check() {
    	Set<Integer> set = new HashSet<>();
    	for (int i = 1; i <= N; i++) {
    		set.add(findParent(i));
    	}
    	
    	if (set.size() == K) return true;
    	return false;
    	
    }
}