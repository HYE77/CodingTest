import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			Stack<Character> stack = new Stack<>();
			List<Integer> pipes = new ArrayList<>();
			String str = br.readLine();
			char[] arr = str.toCharArray();

			boolean justOpen = false;
			
			for(char c : arr) {
				if (c == '(') { // 여는 괄호 입력
					stack.push(c);
					justOpen = true;
				} else { // 닫는 괄호 입력
					if (stack.isEmpty()) { // 비어있음 -> 잘못된 짝
						break;
					} else { // 비어있지 않음
						if (justOpen) { // 레이져임!
							stack.pop();
							pipes.add(stack.size());
							justOpen = false;
						} else { // 레이져 아님! 쇠막대임!
							stack.pop();
							pipes.add(1);
						}
	
					}
				}
			}
			int sum = 0;
			for (int p : pipes) {
				sum += p;
			}
			
			System.out.println("#" + t + " " + sum);
			
		}

	}

}
