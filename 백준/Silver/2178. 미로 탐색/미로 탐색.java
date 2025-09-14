import java.util.*;
import java.io.*;

public class Main {

    static int N, M, ans;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r, c, dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(input.charAt(j)+"");
                if (board[i][j] == 0) visited[i][j] = true;
            }
        }

        bfs(0, 0);

        bw.write(ans+"");

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c, 1));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            // 미로 탈출하면 값 저장하고 끝내기
            if (curr.r == N - 1 && curr.c == M - 1) {
                ans = curr.dist;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;

                q.add(new Node(nr, nc, curr.dist + 1));
                visited[nr][nc] = true;
            }
        }
    }

}
