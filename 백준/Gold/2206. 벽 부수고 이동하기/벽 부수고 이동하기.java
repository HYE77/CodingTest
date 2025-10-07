import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int ans = -1;
    static int[][] grid;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r, c, dist, wall;

        public Node(int r, int c, int dist, int wall) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M][2]; // 0 : 벽을 안 뚫고 방문 / 1 : 벽 뚫고 방문

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = row.charAt(j) - '0';
            }
        }

        // bfs
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.r == N-1 && curr.c == M-1) {
                ans = curr.dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                    // 벽을 만났고 뚫을 수 있는 상태이면서 아직 벽이 뚫리지 않았다면
                    if (grid[nr][nc] == 1 && curr.wall == 0 && !visited[nr][nc][1]) {
                        visited[nr][nc][1] = true;
                        q.add(new Node(nr, nc, curr.dist + 1, 1));
                    }

                    // 벽이 아님~
                    else if (grid[nr][nc] == 0 && !visited[nr][nc][curr.wall]) {
                        visited[nr][nc][curr.wall] = true;
                        q.add(new Node(nr, nc, curr.dist + 1, curr.wall));
                    }
                }
            }
        }

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
