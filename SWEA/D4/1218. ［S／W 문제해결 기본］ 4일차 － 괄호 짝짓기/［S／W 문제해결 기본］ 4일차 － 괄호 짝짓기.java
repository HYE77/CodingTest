import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine()); // length of string
			String str = br.readLine();
			
			char[] arr = str.toCharArray();
			List<Character> opens = new ArrayList<>(Arrays.asList('(', '[', '<', '{'));
			List<Character> closes = new ArrayList<>(Arrays.asList(')', ']', '>', '}'));
			
			Stack<Character> stack = new Stack<>();
			boolean isOk = true;
			
			for (int i = 0; i < len; i++) {
				char temp = arr[i];
				if (opens.contains(temp)) {// 여는 괄호라면
					stack.push(temp);
				} else { // 닫는 괄호라면
					if (stack.isEmpty()) { // 스택이 비었다면 -> 이슈
						isOk = false;
						break;
					} else { // pop해서 비교해보자
						char last = stack.peek();
						if (opens.indexOf(last) == closes.indexOf(temp)) stack.pop(); // 짝이 맞으면 pop
						else { // 짝이 다르면 break
							isOk = false;
							break;
						}
					}
				}
			}
			int ans;
			if (isOk = true && stack.isEmpty()) ans = 1;
			else ans = 0;
			
			System.out.println("#" + t + " " + ans);
		}

	}

}
