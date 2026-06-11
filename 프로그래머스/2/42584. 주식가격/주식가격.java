import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int size = prices.length;
        int[] answer = new int[size];
        
        Arrays.fill(answer, -1);
        
        for (int i = 0; i < size; i++) {
            int cur = prices[i];
            for (int j = i+1; j < size; j++) {
                if (prices[j] < cur) {
                    // 하락했으면
                    answer[i] = j-i;
                    break;
                }
            }
            
            if (answer[i] == -1) answer[i] = size - (i+1);
        }
        
        return answer;
    }
}