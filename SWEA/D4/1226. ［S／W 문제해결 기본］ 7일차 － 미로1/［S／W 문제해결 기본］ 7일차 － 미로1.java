import java.util.*;
import java.io.*;

public class Solution {
    static int[][] board;
    static boolean[][] visited;
    static int startR, startC, targetR, targetC;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean reached;

    static class Node {
        int r, c;

        public Node(int c, int r) {
            this.c = c;
            this.r = r;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 10;
        for (int t = 1; t <= T; t++) {
            board = new int[16][16];
            visited = new boolean[16][16];
            br.readLine(); // 테케 번호 날려
            for (int i = 0; i < 16; i++) {
                String input = br.readLine();
                for (int j = 0; j < 16; j++) {
                    board[i][j] = input.charAt(j) - '0';
                    if (board[i][j] == 1) {
                        visited[i][j] = true;
                    } else if (board[i][j] == 2) {
                        startR = i;
                        startC = j;
                    } else if (board[i][j] == 3) {
                        targetR = i;
                        targetC = j;
                    }
                }
            }

            reached = false;
            bfs(startR, startC);

            bw.write("#" + t + " ");
            if (reached) bw.write("1\n");
            else bw.write("0\n");

        }

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

            if (curr.r == targetR && curr.c == targetC) {
                reached = true;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (visited[nr][nc] || nr < 0 || nc < 0 || nr == 16 || nc == 16) continue;
                q.add(new Node(nr, nc));
                visited[nr][nc] = true;
            }

        }
    }

}
