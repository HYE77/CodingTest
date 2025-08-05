import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 정점 개수
		int M = Integer.parseInt(st.nextToken()); // 간선 개수
		
		// 그래프 생성
		Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
		for (int n = 1; n <= N; n++) {
			graph.put(n, new ArrayList<>());
		}
			
		
		// 그래프 입력받기
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
			
		}
		
		// 방문여부 추적 배열 생성
		boolean[] visited = new boolean[N+1];
		for (int n = 0; n <= N; n++) {
			visited[n] = false;
		}
		
		int cnt = 0; // 연결요소 count
		// 순회 시작
		for (int n = 1; n <= N; n++) {
			if (visited[n] == true) continue; // 이미 방문했으면 pass
			
			dfs(graph, visited, n);
			cnt++; 
		}
		
		System.out.println(cnt);
		
 	}
	
	public static void dfs(Map<Integer, ArrayList<Integer>> graph, boolean[] visited, int v) {
		for (int n : graph.get(v)) {
			if (visited[n] == false) { // 아직 방문 안 했으면
				visited[n] = true;
				dfs(graph, visited, n);
			}
		}
		
	}

}
