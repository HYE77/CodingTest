import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        // idx, 우선순위
        Queue<int[]> q = new ArrayDeque<>();

        int size = priorities.length;

        // 우선순위 리스트
        List<Integer> ps = new ArrayList<>();
        for (int n : priorities) ps.add(n);
        Collections.sort(ps, Collections.reverseOrder());

        // 큐에 넣기
        for (int i = 0; i < size; i++) {
            q.add(new int[] {i, priorities[i]});
        }

        int ans = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            // 우선순위 검증
            // 만약 지금 우선순위가 더 뒤라면 다시 enqueue
            if (cur[1] < ps.get(0)) q.add(cur);
            else {
                if (cur[0] == location) break;
                ps.removeFirst();
                ans++;
            }
        }
        
        return ans;
    }
}