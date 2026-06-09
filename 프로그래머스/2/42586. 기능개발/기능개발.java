import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }

        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[i - 1]) arr[i] = arr[i - 1];
        }

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            q.add(arr[i]);
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int cnt = 1;
            int cur = q.removeFirst();

            while (!q.isEmpty() && q.getFirst() == cur) {
                q.removeFirst();
                cnt++;
            }

            ans.add(cnt);
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
}