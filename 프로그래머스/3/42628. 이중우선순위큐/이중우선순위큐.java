import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        
        for (String str : operations) {
            st = new StringTokenizer(str);
            String cmd = st.nextToken();
            Integer num = Integer.parseInt(st.nextToken());
            
            if ("I".equals(cmd)) {
                minheap.add(num);
                maxheap.add(num);
                map.put(num, map.getOrDefault(num, 0)+1);
            } else {
                // 삭제 연산
                if (minheap.isEmpty() || maxheap.isEmpty()) continue;
                
                if (num == -1) {
                    // 최솟값 삭제
                    while (!minheap.isEmpty() &&
                        (!map.containsKey(minheap.peek()) || map.get(minheap.peek()) <= 0)) {
                        minheap.poll();
                    }

                    if (minheap.isEmpty()) continue;

                    int curMin = minheap.poll();
                    map.put(curMin, map.get(curMin)-1);
                } else {
                    // 최댓값 삭제
                    while (!maxheap.isEmpty() &&
                           (!map.containsKey(maxheap.peek()) || map.get(maxheap.peek()) <= 0)) {
                        maxheap.poll();
                    }

                    if (maxheap.isEmpty()) continue;

                    int curMax = maxheap.poll();
                    map.put(curMax, map.get(curMax)-1);
                }
            }
        }
        
        // 결과 출력
        int[] ans = new int[2];
        if (minheap.isEmpty() || maxheap.isEmpty()) return new int[] {0, 0};
        
        while (!minheap.isEmpty() && (!map.containsKey(minheap.peek()) || map.get(minheap.peek()) <= 0)) {
            minheap.poll();
        }
        
        ans[1] = minheap.isEmpty() ? 0 : minheap.peek();
        
        while (!maxheap.isEmpty() && (!map.containsKey(maxheap.peek()) || map.get(maxheap.peek()) <= 0)) {
            maxheap.poll();
        }
        
        ans[0] = maxheap.isEmpty() ? 0 : maxheap.peek();
        
        return ans;
    }
}