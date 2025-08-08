import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 연산자 우선순위 -> Map 이용
		Map<Character, Integer> priority = new HashMap<>();

		priority.put('*',  2);
		priority.put('+',  1);
		priority.put('(',  0);
		
		// testcase 돌기
		for (int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine());
			String infix = br.readLine();
			
			StringBuilder postfix = new StringBuilder(); // 출력할 중위표기법 저장
			Stack<Character> op = new Stack<>(); // 연산자 담는 스택
			
			// 후위표기식 만들기
			for (int i = 0; i < len; i++) {
				char tmp = infix.charAt(i);
				// 피연산자라면
				if (tmp >= '0' && tmp <= '9') {
					postfix.append(tmp);
				} else if (tmp == '(') { // 여는 소괄호라면
					op.add(tmp);
				} else if (tmp == ')') { // 닫는 소괄호라면 {
					while (op.peek() != '(') {
						postfix.append(op.pop());
					}
					op.pop(); // -> 여는 소괄호 빼기
				} else { // 연산자라면
					if (op.isEmpty()) { // 공백이면 무조건 push
						op.add(tmp);
					} else { // 공백이 아니라면 -> 연산자 우선순위 비교해서 처리
						if (priority.get(tmp) > priority.get(op.peek())) { // 우선순위가 더 높다면
							op.add(tmp);
						} else { // 우선순위가 같거나 낮다면
							while (priority.get(op.peek()) >= priority.get(tmp) && !op.isEmpty()) { // 낮은 애 만날 때까지 push pop
								postfix.append(op.pop());
							}
							op.add(tmp);
						}
					}
				}
			}
			
			while (!op.isEmpty()) {
				postfix.append(op.pop());
			}
			
			
			// 후위표기식 계산하기
			Stack<Integer> cal = new Stack<>(); // 연산자 담는 스택
			for (int i = 0; i < postfix.length(); i++) {
				char tmp = postfix.charAt(i);
				if (tmp >= '0' && tmp <= '9') { // 피연산자라면
					cal.add(Integer.parseInt(tmp+""));
				} else {
					int second = cal.pop();
					int first = cal.pop();
					
					switch (tmp) {
					case '+' :
						cal.add(first+second);
						break;
					case '*' :
						cal.add(first*second);
						break;
					}
				}
			}
			
			int ans = cal.pop();
			
			System.out.println("#" + t + " " + ans);
			
		}
	
		br.close();	
		
	}

}
