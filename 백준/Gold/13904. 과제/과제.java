import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int day, score;

        public Node(int day, int score) {
            this.day = day;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            return this.score == o.score ? Integer.compare(o.day, this.day) : Integer.compare(o.score, this.score);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int maxDay = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            pq.add(new Node(day, sc));
            maxDay = Math.max(maxDay, day);
        }

        boolean[] used = new boolean[maxDay + 1];
        int ans = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = cur.day; i > 0; i--) {
                if (!used[i]) {
                    used[i] = true;
                    ans += cur.score;
                    break;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}