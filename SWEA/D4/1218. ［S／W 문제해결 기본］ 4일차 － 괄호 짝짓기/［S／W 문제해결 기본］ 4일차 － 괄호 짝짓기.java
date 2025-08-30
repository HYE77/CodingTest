import java.util.*;
import java.io.*;

public class Solution {

    static List<Character> open = new ArrayList<>(Arrays.asList('(', '{', '<', '['));
    static List<Character> close = new ArrayList<>(Arrays.asList(')', '}', '>', ']'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            char[] arr = input.toCharArray();

            Stack<Character> stack = new Stack<>();

            boolean isOk = true;
            for (char c : arr) {
                if (open.contains(c)) {
                    // 여는 괄호라면
                    stack.push(c);
                } else {
                    // 닫는 괄활면
                    char tmp = stack.pop();
                    if (open.indexOf(tmp) != close.indexOf(c)) {
                        isOk = false;
                        break;
                    }
                }
            }

            if (stack.isEmpty() && isOk)
                System.out.println("#" + t + " 1" );
            else System.out.println("#" + t + " 0");

        }

        br.close();

    }

}