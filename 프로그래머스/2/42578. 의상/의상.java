import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> closet = new HashMap<>();
        
        // 옷장 수납
        for (String[] pair : clothes) {
            String name = pair[0];
            String category = pair[1];
            
            closet.put(category, closet.getOrDefault(category, 0)+1);
        }
        
        // 경우의 수 계산
        for (String key : closet.keySet()) {
            answer *= (closet.get(key)+1);
        }
        
        return answer-1;
    }
}