import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int one = 0;
        int two = 0;
        int three = 0;
        
        for (int i = 0; i < answers.length; i++) {
            one += first[i%first.length] == answers[i] ? 1 : 0;
            two += second[i%second.length] == answers[i] ? 1 : 0;
            three += third[i%third.length] == answers[i] ? 1 : 0;
        }
        
        int max = Math.max(Math.max(one, two), three);
        
        List<Integer> lst = new ArrayList<>();
        if (one == max) lst.add(1);
        if (two == max) lst.add(2);
        if (three == max) lst.add(3);
        
        int[] answer = new int[lst.size()];
        int i = 0;
        for (int n : lst) {
            answer[i++] = n;
        }
        
        Arrays.sort(answer);
        
        return answer;       
        
    }
}