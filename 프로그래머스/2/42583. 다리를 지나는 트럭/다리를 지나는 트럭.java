import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        /* bridge_length : 다리에 올라갈 수있는 트럭 수
         * weight : 다리가 버틸 수 있는 무게
         * truck_weights : 트럭들의 무게
         */ 
        
        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        Deque<Integer> waiting = new ArrayDeque<>();
        for (int n : truck_weights) waiting.add(n);
        
        int time = 0; // 경과 시간
        int w = 0; // 현재 다리 위 트럭 무게 합
        while (true) {
            // 올라갈 트럭
            int cur = !waiting.isEmpty() ? waiting.poll() : 0;
            
            // 현재 올라가 있는 트럭 보내기
            int prev = bridge.poll();
            w -= prev;
            
            // 무게 확인
            // 올릴 수 있다면
            if (w + cur <= weight) {
                
                bridge.add(cur);
                w += cur;
            } else {
                // 올릴 수 없다면
                bridge.add(0);
                waiting.addFirst(cur);
            }
            
            time++;
            
            // 종료 조건 확인
            if (waiting.isEmpty() && w == 0) break;
        }
        
        return time;
        
    }
}