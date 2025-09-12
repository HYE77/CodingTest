import java.util.*;
import java.io.*;
 
public class Solution {
     
	static int N;
	static int[][] place;
	static int[][] dist;
	static final int INF = Integer.MAX_VALUE;
	static boolean[][] visited;
	static int ans = 0;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1}; // 상 하 좌 우
	
	static class Node implements Comparable<Node> {
		int r, c, dist;

		public Node(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	N = Integer.parseInt(br.readLine());
        	
        	// 배열 만들기
        	place = new int[N][N];
        	for (int i = 0; i < N; i++) {
        		String row = br.readLine();
        		for (int j = 0; j < N; j++) {
        			place[i][j] = Integer.parseInt(row.charAt(j) +"");
        		}
        	}
        	
        	dist = new int[N][N];
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			dist[i][j] = INF;
        		}
        	}
        	
        	visited = new boolean[N][N];
        	
        	// 최단시간 구하기
        	dijkstra(0, 0);
        	
        	bw.write("#" + t + " " + dist[N-1][N-1] + "\n");
        	
        }
 
        
        bw.flush();
        br.close();
        bw.close();
         
    }
    
    
    static void dijkstra(int r, int c) {
    	dist[r][c] = 0;
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(r, c, 0));
    	
    	while (!pq.isEmpty()) {
    		
    		Node curr = pq.poll();
    		if (visited[curr.r][curr.c] == true) continue;
    		
    		visited[curr.r][curr.c] = true; 
    		
    		for (int i = 0; i < 4; i++) {
    			int nr = curr.r + dr[i];
    			int nc = curr.c + dc[i];
    			
    			if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
    			if (!visited[nr][nc] && dist[nr][nc] > dist[curr.r][curr.c] + place[nr][nc]) {
    				dist[nr][nc] = dist[curr.r][curr.c] + place[nr][nc];
    				pq.add(new Node(nr, nc, dist[nr][nc]));
    			}
    		}
    	}
 	
    }

}