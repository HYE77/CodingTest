import java.util.*;
import java.io.*;

public class Main {
	
	static int N, total, minDiff;
	static int[] population;
	static int[] selected;
	static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 지역 개수
		population = new int[N+1];
		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] =  Integer.parseInt(st.nextToken());
			total += population[i];
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int neighbor = Integer.parseInt(st.nextToken());
			for (int j = 0; j < neighbor; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		minDiff = Integer.MAX_VALUE;
		for (int s = 1; s <= N/2; s++) {
			selected = new int[s];
			comb(s, 1, 0);
		}
		
		System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
		br.close();
	}
	
	static void comb(int size, int idx, int sIdx) {
		// 다 골랐다면
		if (sIdx == size) {
			if (districtCheck()) minDiff = Math.min(minDiff, calcDiff());
			return;
		}
		
		// 고르기
		for (int i = idx; i <= N; i++) {
			selected[sIdx] = i;
			comb(size, i+1, sIdx+1);
		}
	}
	
	
	static boolean districtCheck() {
		// BFS를 통해 두 구역이 각자 잘 연결되어 있는지 확인
		boolean[] visited = new boolean[N+1];
		
		int[] district = new int[N+1];
		Arrays.fill(district, 1);
		for (int n : selected) district[n] = 2; // 1, 2 숫자로 구역 구분
		
		// 구역2(selected)부터 확인
		Queue<Integer> q = new ArrayDeque<>();
		q.add(selected[0]);
		visited[selected[0]] = true;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int c : adj[curr]) {
				if (!visited[c] && district[c] == district[curr]) {
					q.add(c);
					visited[c] = true;
				}
			}
		}
		
		for (int n : selected) {
			if (!visited[n]) return false;
		}
		
		// 구역2는 잘 연결되어 있음. 구역1을 확인하자.
		q = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) { // 시작지점 넣기
			if (district[i] == 1) {
				q.add(i);
				visited[i] = true;
				break;
			}
		}
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int c : adj[curr]) {
				if (!visited[c] && district[c] == district[curr]) {
					q.add(c);
					visited[c] = true;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) return false;
		}
		
		return true;
	}
	
	
	static int calcDiff() {
		int sum = 0;
		
		for (int n : selected) {
			sum += population[n];
		}
		
		int ans = Math.abs(sum - (total-sum));
		
		return ans;
	}
}
