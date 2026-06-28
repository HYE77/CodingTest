import java.util.*;

class Solution {
    public int solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty() || stack.peek() != c) stack.add(c);
            else stack.pop();
        }
        
        if (stack.isEmpty()) return 1;
        return 0;

    }
}