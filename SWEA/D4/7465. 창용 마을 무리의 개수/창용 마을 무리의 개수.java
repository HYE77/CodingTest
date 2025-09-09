import java.util.*;
import java.io.*;

public class Solution {

	static Map<Integer, List<Integer>> map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 1~N번 사람
			int M = Integer.parseInt(st.nextToken()); // 관계의 수
			
			visited = new boolean[N+1];
			
			// 맵 초기화
			map = new HashMap<>();
			for (int p = 1; p <= N; p++) {
				map.put(p, new ArrayList<Integer>());
			}
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map.get(x).add(y);
				map.get(y).add(x);
			}
			
			int cnt = 0;
			for (int p = 1; p <= N; p++) {
				if (visited[p] == false) {
					dfs(p);
					cnt++;
				}
			}
			
			bw.write("#" + t + " " + cnt + "\n");
		}

		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	static void dfs(int p) {
		// p를 시작점으로 깊이우선탐색
		
		visited[p] = true;
		
		for (int n : map.get(p)) {
			if (visited[n] == false) dfs(n);
		}
	}

}
