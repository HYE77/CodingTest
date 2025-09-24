import java.util.*;
import java.io.*;

public class Main {
	
	static int V, E;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dist = new int[V+1][V+1];
		
		for (int i = 0; i <= V; i++) {
			for (int j = 0; j <= V; j++) {
				if (i != j) dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			dist[from][to] = 1;
			dist[to][from] = 1;
		}
		
		for (int k = 1; k < V+1; k++) {
			for (int i = 1; i < V+1; i++) {
				if (dist[i][k] == Integer.MAX_VALUE) continue;
				for (int j = 1; j < V+1; j++) {
					if (dist[k][j] == Integer.MAX_VALUE) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					dist[j][i] = Math.min(dist[j][i], dist[j][k] + dist[k][i]);
				}
			}
		}
		
		int who = -1;
		int minValue = Integer.MAX_VALUE;
		for (int row = 1; row < V+1; row++) {
			int[] line = dist[row];
			int tmp = 0;
			for (int c = 1; c < V+1; c++) {
				tmp += line[c];
			}
			if (tmp < minValue) {
				minValue = tmp;
				who = row;
			}
			
		}
		
		bw.write(who+"");
		
		bw.flush();
		br.close();
		bw.close();
	}
}
