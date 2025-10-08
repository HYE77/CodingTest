import java.io.*;
import java.util.*;

public class Main {

    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        String infix = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            Character curr = infix.charAt(i);
            if (curr >= 'A' && curr <= 'Z') sb.append(curr);
            else if (curr == '(')  stack.push(curr);
            else if (curr == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // 여는 괄호 뽑기
            } else { // 연산자일 때
                if (stack.isEmpty() || map.get(stack.peek()) < map.get(curr)) stack.push(curr);
                else {
                    while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(curr)) {
                        sb.append(stack.pop());
                    }
                    stack.push(curr);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
