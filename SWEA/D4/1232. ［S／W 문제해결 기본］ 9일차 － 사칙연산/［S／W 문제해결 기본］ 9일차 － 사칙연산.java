import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String[][] tree = new String[N+1][3];
			
			// 트리 만들기
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				
				int node = Integer.parseInt(st.nextToken()); // 몇 번째 노드?
				tree[node][0] = st.nextToken();
				
				if (st.hasMoreTokens()) {
					tree[node][1] = st.nextToken(); //왼쪽 자식
				}
				
				if (st.hasMoreTokens() ) {
					tree[node][2] = st.nextToken(); //오른쪽 자식
				}
			}
			
			// 후위표기식 담을 Stringbuilder
			StringBuilder sb = new StringBuilder();
			
			// 후위순회하며 후외표기식으로 만들기
			postOrder(tree, 1, sb);
			String[] postfix = sb.toString().split(" ");
			
			// 후위표기식 계산하기
			Stack<Integer> stack = new Stack<>();
			
			List<String> cal = new ArrayList<>();
			cal.add("+");
			cal.add("-");
			cal.add("/");
			cal.add("*");
			
			for (int i = 0; i < postfix.length; i++) {
				if (!cal.contains(postfix[i])) { // 피연산자라면
					stack.add(Integer.parseInt(postfix[i]));
				} else { // 연산자라면
					String cmd = postfix[i];
					int second = stack.pop();
					int first = stack.pop();
					
					switch (cmd) {
					case "+" : stack.add(first+second); break;
					case "-" : stack.add(first-second); break;
					case "/" : stack.add(first/second); break;
					case "*" : stack.add(first*second); break;
					}
				}
			}
			
			int ans = stack.pop();
			System.out.println("#" + t + " " + ans);
			
			
			
			
			
		}

	}
	
	public static void postOrder(String[][] tree, int v, StringBuilder sb) {
		if (v < tree.length) {
			if (tree[v][1] != null) {
				postOrder(tree, Integer.parseInt(tree[v][1]), sb);
			}
			
			if (tree[v][2] != null) {
				postOrder(tree, Integer.parseInt(tree[v][2]), sb);
			}
			
			sb.append(tree[v][0]).append(" ");
		}
		
	}

}
