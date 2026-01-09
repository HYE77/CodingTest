import java.util.*;
import java.io.*;

public class Main {

    static int K, W, H;
    static int[][] grid;
    static boolean[][][] visitCase;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] horse = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    static class Node {

        int r;
        int c;
        int horseCnt;
        int moveCnt;

        public Node(int r, int c, int horseCnt, int moveCnt) {
            this.r = r;
            this.c = c;
            this.horseCnt = horseCnt;
            this.moveCnt = moveCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        grid = new int[H][W]; // 1: 장애물
        int ans = 1_000_000_000; // 몇 스텝만에 도달했는지
        visitCase = new boolean[H][W][K+1]; // 말 움직임 몇 번 해서 도달했나

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색 시작
        Queue<Node> q = new ArrayDeque<>();
        visitCase[0][0][0] = true;
        q.add(new Node(0, 0, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 도달했다면
            if (cur.r == H-1 && cur.c == W-1) {
                ans = Math.min(ans, cur.moveCnt);
                continue;
            }

            // 네 방향으로 가는 경우
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= H || nc >= W || grid[nr][nc] == 1) continue;
                if (visitCase[nr][nc][cur.horseCnt]) continue;

                visitCase[nr][nc][cur.horseCnt] = true;
                q.add(new Node(nr, nc, cur.horseCnt, cur.moveCnt+1));
            }

            // 말처럼 가는 경우
            if (cur.horseCnt == K) continue;
            for (int[] move : horse) {
                int nr = cur.r + move[0];
                int nc = cur.c + move[1];

                if (nr < 0 || nc < 0 || nr >= H || nc >= W || grid[nr][nc] == 1) continue;
                if (visitCase[nr][nc][cur.horseCnt+1]) continue;

                visitCase[nr][nc][cur.horseCnt+1] = true;
                q.add(new Node(nr, nc, cur.horseCnt+1, cur.moveCnt+1));
            }
        }

        System.out.println(ans == 1_000_000_000 ? -1 : ans);
    }
}