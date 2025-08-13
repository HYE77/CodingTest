import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken()); // 정점 개수
			int E = Integer.parseInt(st.nextToken()); // 간선 개수 (V-1)
			int n1 = Integer.parseInt(st.nextToken()); // 타겟 정점 1
			int n2 = Integer.parseInt(st.nextToken()); // 타겟 정점 2
			
			int[][] tree = new int[V+1][3]; // 순서: 부모 - 왼 - 오
			
			// 트리 만들기
			st = new StringTokenizer(br.readLine());
			for (int e = 0; e < E; e++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				tree[c][0] = p;
				if (tree[p][1] == 0)
					tree[p][1] = c;
				else
					tree[p][2] = c;
				
			}
			
			// n1의 조상 리스트 만들기
			List<Integer> ansc = new ArrayList<>();
			int curr = n1;
			while (tree[curr][0] != 0) {
				curr = tree[curr][0];
				ansc.add(curr);
			}
			
			// n2의 조상 중 가장 가까운 공통 조상 찾기
			int par = n2;
			while (true) {
				par = tree[par][0];
				if (ansc.contains(par)) break;
			}
			
			// 해당 노드를 루트로 하는 서브 트리의 크기 구하기
			List<Integer> subtree = new ArrayList<>();
			preorder(tree, par, subtree);
			
			// 결과 출력
			System.out.println("#" + t + " " + par + " " + subtree.size());
			
		}
	}
	
	public static void preorder(int[][] tree, int v, List<Integer> list) {
		if (v < tree.length && v > 0) {
			list.add(v); // 노드 추가
			preorder(tree, tree[v][1], list);
			preorder(tree, tree[v][2], list);
		}
	}

}
