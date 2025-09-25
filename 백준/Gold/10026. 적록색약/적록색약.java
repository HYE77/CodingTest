
import java.util.*;
import java.io.*;

public class Main {

    static int N, ans1, ans2;
    static char[][] grid;
    static boolean[][] visited1, visited2;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        // fill grid
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = input.charAt(j);
            }
        }

        // 색약 아닌 사람의 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    bfs(i, j, grid[i][j], visited1);
                    ans1++;
                }
            }
        }

        // 색약의 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'G') grid[i][j] = 'R';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited2[i][j]) {
                    bfs(i, j, grid[i][j], visited2);
                    ans2++;
                }
            }
        }

        sb.append(ans1).append(" ").append(ans2);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int startR, int startC, char color, boolean[][] visited) {

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(startR, startC));
        visited[startR][startC] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || grid[nr][nc] != color) continue;

                q.add(new Node(nr, nc));
                visited[nr][nc] = true;
            }
        }
    }
}
