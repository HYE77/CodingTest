import java.util.*;
import java.io.*;

public class Solution {
	
	static int N;
	static Island[] islands;
	static ArrayList<Edge> edges;
	static Island[] selected;
	static int[] p;
	
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
			
			// 서로소집합 초기화
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}
			
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
			
			// edge 리스트 만들기
			edges = new ArrayList<>();
			selected = new Island[2];
			findAllEdges(0, 0);
			
			// edge 리스트 정렬
			Collections.sort(edges);
			
			// Kruskal 알고리즘으로 MST 탐색
			int edgeCnt = 0;
			int edgeIdx = 0;
			long answer = 0l;
			while (edgeCnt < N-1 && edgeIdx < edges.size()) {
				Edge tmp = edges.get(edgeIdx);
				int a = tmp.from;
				int b = tmp.to;
				
				int pa = findSet(a);
				int pb = findSet(b);
				
				if (pa != pb) {
					p[pa] = pb;
					answer += tmp.dist;
					edgeCnt++;
				}
				
				edgeIdx++;
				
			}
			answer = Math.round(answer * E);
			bw.write("#" + t + " " + answer + "\n");
			
			
		}

		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	static void findAllEdges(int sidx, int idx) {
		// 조합 완성했으면
		if (sidx == 2) {
			Island a = selected[0];
			Island b = selected[1];
			long distance = (long) (Math.pow(a.x-b.x, 2) +  Math.pow(a.y-b.y, 2));
			
			edges.add(new Edge(a.idx, b.idx, distance));
			return;
		}
		
		for (int i = idx; i < N; i++) {
			selected[sidx] = islands[i];
			findAllEdges(sidx+1, i+1);
		}
		
	}
	
	
	static int findSet(int v) {
		if (p[v] != v) p[v] = findSet(p[v]);
		return p[v]; 
	}
	

}
