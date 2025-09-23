import org.w3c.dom.Node;

import java.util.*;
import java.io.*;

public class Main {

    static int N, M, ans;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new char[N][M];
        visited = new boolean[N][M];

        int startR = -1;
        int startC = -1;
        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < M; c++) {
                grid[r][c] = input.charAt(c);
                if (grid[r][c] == 'I') {
                    startR = r;
                    startC = c;
                }
            }
        }

        bfs(startR, startC);
        bw.write(ans > 0 ? ans+"" : "TT");

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int startR, int startC) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startR, startC));
        visited[startR][startC] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nc < 0 || nr == N || nc == M || visited[nr][nc] || grid[nr][nc] == 'X') continue;
                if (grid[nr][nc] == 'P') ans++;
                q.add(new Node(nr, nc));
                visited[nr][nc] = true;
            }
        }
    }
}
