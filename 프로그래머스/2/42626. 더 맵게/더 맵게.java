import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 우선순위 큐에 넣기 (min heap)
        for (int n : scoville) {
            pq.add(n);
        }
        
        // 계산하기
        int ans = 0;
        if (pq.peek() >= K) return 0;
        
        while (pq.size() > 1) {
            ans++;
            
            int n1 = pq.poll();
            int n2 = pq.poll();
            int tmp = n1 + 2 * n2;
            
            pq.add(tmp);
            
            if (pq.peek() >= K) return ans;
        }
        
        return -1;
    }
}