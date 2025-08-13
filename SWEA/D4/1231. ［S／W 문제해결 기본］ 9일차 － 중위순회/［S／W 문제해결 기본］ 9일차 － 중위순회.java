import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String[][] tree = new String[N+1][3];
			
			// tree 만들기
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
			
				int node = Integer.parseInt(st.nextToken());
				tree[node][0] = st.nextToken();
				
				if (st.hasMoreTokens()) { // 왼쪽 자식 있다면
					tree[node][1] = st.nextToken();
				}
				
				if (st.hasMoreTokens()) { // 오른쪽 자식 있다면
					tree[node][2] = st.nextToken();
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			inorder(tree, 1, sb);
			
			System.out.println(sb);
		}
	}
	
	
	public static void inorder(String[][] tree, int v, StringBuilder sb) {
		if (v < tree.length) {
			
			if (tree[v][1] != null) { // 왼쪽 자식 있다면
				inorder(tree, Integer.parseInt(tree[v][1]), sb);
			}
			
			sb.append(tree[v][0]);
			
			if (tree[v][2] != null) { //  오른쪽 자식 있다면
				inorder(tree, Integer.parseInt(tree[v][2]), sb);
			}
		}
	}

}
