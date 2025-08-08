import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine()); // 문자열 길이
			String str = br.readLine();

			StringBuilder postfix = new StringBuilder(); // 출력할 중위표기법 저장
			Stack<Character> op = new Stack<>(); // 연산자 담는 스택
			
			// 글자를 하나씩 읽어오자~ -> 피연산자는 한자리수임을 보장하겠다!
			for (int i = 0; i < len; i++) {
				char tmp = str.charAt(i);
				// 피연산자라면
				if (tmp >= '0' && tmp <= '9') {
					postfix.append(tmp);
				} else { // + 연산자라면
					if (op.isEmpty()) op.add(tmp);
					else { // 비어있지 않으면
						postfix.append(op.pop());
						op.add(tmp);
					}
				}
			
			}
			
			while (!op.isEmpty()) {
				postfix.append(op.pop());
			} // 후위표기식 완성
			

			
			// 결과값 계산하기
			Stack<Integer> cal = new Stack<>();
			for (int i = 0; i < postfix.length(); i++) {
				char tmp = postfix.charAt(i);
				
				// 피연산자라면
				if (tmp >= '0' && tmp <= '9') {
					cal.add(Integer.parseInt(tmp+""));
				} else {
					int first = cal.pop();
					int second = cal.pop();
					
					cal.add(first+second);
				}
				
					
			}
		
			// 출력하기
			System.out.println("#" + t + " " + cal.pop());
	

		}
	br.close();
		
	}
}
