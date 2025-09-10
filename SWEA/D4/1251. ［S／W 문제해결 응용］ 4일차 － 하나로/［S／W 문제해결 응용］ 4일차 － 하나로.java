import java.util.*;
import java.io.*;
 
public class Solution {
     
    static int N;
    static Island[] islands;
    static List<Edge>[] adj;
    static boolean[] visited;
    static long[] dist;
    static long answer;
     
    static class Island {
        int idx, x, y; // 섬 번호, x좌표, y좌표
         
        public Island(int idx, int x) {
            this.idx = idx;
            this.x = x;
        }
 
        public Island(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }
     
    static class Edge implements Comparable<Edge> {
        int from, to;
        long dist; // 출발섬, 도착섬, 거리 제곱
 
        public Edge(int from, int to, long dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
        
        public Edge(int to, long dist) {
            this.to = to;
            this.dist = dist;
        }
 
        @Override
        public int compareTo(Edge o) {
            if (this.dist < o.dist) return -1;
            else return 1;
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
             
            N = Integer.parseInt(br.readLine()); // 섬의 개수
            islands = new Island[N]; // 섬 객체 배열 선언
            visited = new boolean[N];
             
            // 섬 배열 만들기
            // 1) 섬 인덱스와 x좌표 저장
            st = new StringTokenizer(br.readLine()); // 섬들의 x좌표
            for (int n = 0; n < N; n++) {
                islands[n] = new Island(n, Integer.parseInt(st.nextToken()));
            }
             
            // 2) y좌표 추가
            st = new StringTokenizer(br.readLine()); // 섬들의 y좌표
            for (int n = 0; n < N; n++) {
                islands[n].y =Integer.parseInt(st.nextToken());
            }
             
            double E = Double.parseDouble(br.readLine()); // 세율

            
            // 섬 리스트에서 2개씩 뽑아서 edge 정보 adj에 추가하기
            adj = new ArrayList[N];
            for (int i = 0; i < N; i++) {
    			adj[i] = new ArrayList<>();
    		} // 초기화 완료
            
            for (int i = 0; i < N; i++) {
            	for (int j = i+1; j < N; j++) {
            		Island a = islands[i];
            		Island b = islands[j];
            		long distance = (long) (Math.pow(a.x-b.x, 2) +  Math.pow(a.y-b.y, 2));
            		
            		adj[a.idx].add(new Edge(b.idx, distance)); // to, distance
            		adj[b.idx].add(new Edge(a.idx, distance)); // to, distance
            		
            	}
            }
             
           
            // MST 만들기
            dist = new long[N];
            Arrays.fill(dist, Long.MAX_VALUE);
            long answer = 0l;
            
            dijkstra(0);
            
            for (long d : dist) {
            	answer += d;
            }
            
            answer = Math.round(answer * E);
            bw.write("#" + t + " " + answer + "\n");
             
             
        }
 
         
        bw.flush();
        br.close();
        bw.close();
         
    }
     
    static void dijkstra(int start) {
    	
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
    	
    	dist[0] = 0;
    	
    	pq.add(new Edge(start, 0));
    	
    	while (!pq.isEmpty()) {
    		Edge curr = pq.poll(); // 제일 가까운 애 뽑았다
    		
    		if (visited[curr.to]) continue;
    		visited[curr.to] = true; // 방문처리
    		
    		// 얘의 이웃들 중 갱신할 거 있으면 하자
    		for (Edge e : adj[curr.to]) {
    			if (!visited[e.to] && dist[e.to] > e.dist ) {
    				dist[e.to] =   e.dist;
    				pq.add(new Edge(e.to, dist[e.to]));
    			}
    		}
    			
    	}	
    	
    }

     
 
}