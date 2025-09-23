import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] grid;
	static int[][] dist;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Node implements Comparable<Node>{
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
		
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		dist = new int[N][N];
		visited = new boolean[N][N];
		
		for (int[] arr : dist) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}
		
		// grid 만들기
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = Math.abs(input.charAt(j) - '1'); // 1 -> 0, 0 -> 1로 바꾸기 위해서
			}
		}
		
		bfs(0, 0);
		bw.write(dist[N-1][N-1] + "");
		
		
		br.close();
		bw.close();
	}
	
	static void bfs(int startR, int startC) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[startR][startC] = 0;
		pq.add(new Node(startR, startC, 0));
		
		while (!pq.isEmpty()) {
			
			Node curr = pq.poll();
			
			if (visited[curr.r][curr.c]) continue;
			visited[curr.r][curr.c] = true;
			
			// 인접 노드 탐색
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr == N || nc == N) continue;
				if (!visited[nr][nc] && dist[nr][nc] > curr.dist + grid[nr][nc]) {
					dist[nr][nc] = curr.dist + grid[nr][nc];
					pq.add(new Node(nr, nc, dist[nr][nc]));
				}
			}
		
		}
		
	}

}
