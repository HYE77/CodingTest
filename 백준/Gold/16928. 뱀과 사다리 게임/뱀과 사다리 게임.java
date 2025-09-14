import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static boolean[] visited;
    static Map<Integer, Integer> map = new HashMap<>();

    static class Node {
        int pos, dist;

        public Node(int pos, int dist) {
            this.pos = pos; // 좌표
            this.dist = dist; // 몇 번째?
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사다리 수
        M = Integer.parseInt(st.nextToken()); // 뱀 수
        visited = new boolean[101];

        for (int i = 0; i < M+N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map.put(from, to);
        }

        bfs(1);

        bw.write(answer +"");

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int n) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            // 뱀 or 사다리 타기
            while (map.containsKey(curr.pos)) {
                curr.pos = map.get(curr.pos);
                visited[curr.pos] = true;
            }

            if (curr.pos == 100) {
                answer = curr.dist;
                return;
            }

            for (int i = 1; i <= 6; i++) {
                if (visited[curr.pos + 1] || curr.pos + i > 100) continue;
                q.add(new Node(curr.pos + i, curr.dist+1));
                visited[curr.pos] = true;
            }

        }

    }

}
