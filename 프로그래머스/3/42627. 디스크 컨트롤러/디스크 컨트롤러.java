import java.util.*;

class Solution {

    static class Work implements Comparable<Work> {
        int startTime;
        int workTime;

        Work(int startTime, int workTime) {
            this.startTime = startTime;
            this.workTime = workTime;
        }

        @Override
        public int compareTo(Work o) {
            if (this.workTime != o.workTime) {
                return this.workTime - o.workTime;
            }
            return this.startTime - o.startTime;
        }
    }

    public int solution(int[][] jobs) {

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<Work> pq = new PriorityQueue<>();

        int idx = 0;
        int curTime = 0;
        int total = 0;
        int count = 0;
        int n = jobs.length;

        while (count < n) {

            while (idx < n && jobs[idx][0] <= curTime) {
                pq.offer(new Work(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (pq.isEmpty()) {
                curTime = jobs[idx][0];
            } else {
                Work cur = pq.poll();

                curTime += cur.workTime;
                total += curTime - cur.startTime;
                count++;
            }
        }

        return total / n;
    }
}