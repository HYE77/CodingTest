import java.util.*;
import java.io.*;

public class Main {
	static int[][] cave;
	static int[][] minDist;
	static int N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
    static class Node implements Comparable<Node> {
        int x, y, cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			cave = new int[N][N];
			minDist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					minDist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			int ans = search(0, 0);
			
			bw.write("Problem " + t + ": " + ans + "\n");
			t++;
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	public static int search(int startX, int startY) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(startX, startY, cave[startX][startY]));
		minDist[startX][startY] = cave[startX][startY];
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if (curr.cost > minDist[curr.x][curr.y]) continue;
			
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dr[i];
				int ny = curr.y + dc[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				int newDist = curr.cost + cave[nx][ny];
				if (newDist < minDist[nx][ny]) {
					minDist[nx][ny] = newDist;
					pq.offer(new Node(nx, ny, newDist));
				}
			}
		}
		
		return minDist[N-1][N-1];
	}

}

