import java.util.*;
import java.io.*;

public class Main {

    static int N, K, answer;
    static boolean[] visited;

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

        N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치 (target)
        visited = new boolean[1000001];
        bfs(N);

        bw.write(answer+"");

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

            if (curr.pos == K) {
                answer = curr.dist; // 동생 찾았으면 정답 저장
                return;
            }

            // case 1
            int nPos = curr.pos - 1;
            if (nPos >= 0 && !visited[nPos]) {
                q.add(new Node(nPos, curr.dist+1));
                visited[nPos] = true;
            }

            // case 2
            int nPos2 = curr.pos + 1;
            if (nPos2 <= 100000 && !visited[nPos2]) {
                q.add(new Node(nPos2, curr.dist+1));
                visited[nPos2] = true;
            }

            // case 3
            int nPos3 = curr.pos * 2;
            if (nPos3 <= 100000 && !visited[nPos3]) {
                q.add(new Node(nPos3, curr.dist+1));
                visited[nPos3] = true;
            }
        }
    }
}
