import java.util.*;

class Solution {
    boolean solution(String s) {
        
        boolean ans = true;
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // 여는 괄호라면
            if (c == '(') stack.add(c);
            
            // 닫는 괄호라면
            else {
                // 스택이 비어있다면
                if (stack.isEmpty()) {
                    ans = false;
                    break;
                } else {
                    // 여는 괄호랑 짝지어서 pop
                    stack.pop();
                }
            }
        }
        
        if (!stack.isEmpty()) ans = false;
        
        return ans;
    }
}