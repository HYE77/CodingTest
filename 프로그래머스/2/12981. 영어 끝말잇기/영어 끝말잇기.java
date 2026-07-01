import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        boolean flag = false;
        char last = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            if (!set.contains(words[i]) && last == words[i].charAt(0)) {
                set.add(words[i]);
                last = words[i].charAt(words[i].length()-1);
            } else {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                flag = true;
                break;
            }
        }
        
        if (!flag) {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }
}