import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] adj;
	static int[][] adjFinal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		adj = new int[N][N];
		adjFinal = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			
			bfs(i);
		}
		
		for (int[] arr : adjFinal) {
			for (int n : arr) {
				bw.write(n + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void bfs(int start) {
		
		boolean[] visited = new boolean[N];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		adjFinal[start][start] = adj[start][start];
		
		while (!q.isEmpty()) {
			
			int curr = q.poll();
			if (visited[curr]) continue;
			visited[curr] = true;
			
			for (int n = 0; n < N; n++) {
				if (adj[curr][n] == 1) {
					q.add(n);
					adjFinal[start][n] = 1;
					adjFinal[curr][n] = 1;
				}
			}
		}
	}

}
