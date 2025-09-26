
import java.util.*;
import java.io.*;

public class Main {

    static int M, N, H; // 가로, 세로, 높이
    static int[][][] box;
    static boolean[][][] visited;
    static List<int[]> tomatos;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] dh = {-1, 1};
    static class Node {
        int r, c, h, day;

        public Node(int r, int c, int h, int day) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        tomatos = new ArrayList<>();

        boolean allApple = true;
        for (int f = 0; f < H; f++) {
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    box[f][r][c] = Integer.parseInt(st.nextToken());
                    if (box[f][r][c] == 1) tomatos.add(new int[]{r, c, f});
                    else if (box[f][r][c] == -1) visited[f][r][c] = true;
                    if (box[f][r][c] != 1) allApple = false;
                }
            }
        }

        if (allApple) sb.append("0");
        else {
            search();

            boolean bad = false;
            int day = -1;
            for (int h = 0; h < H; h++) {
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < M; c++) {
                        if (!visited[h][r][c]) {
                            bad = true;
                            break;
                        }
                        day = Math.max(day, box[h][r][c]);
                    }
                    if (bad) break;
                }
                if (bad) break;
            }

            if (bad) sb.append("-1");
            else sb.append(day);
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static void search() {

        Queue<Node> q = new ArrayDeque<>();

        for (int[] tomato : tomatos) {
            q.add(new Node(tomato[0], tomato[1], tomato[2], 0));
            box[tomato[2]][tomato[0]][tomato[1]] = 0;
            visited[tomato[2]][tomato[0]][tomato[1]] = true;
        }

        while (!q.isEmpty()) {

            Node curr = q.poll();

            // 동서남북 탐색
            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || box[curr.h][nr][nc] != 0 || visited[curr.h][nr][nc]) continue;
                q.add(new Node(nr, nc, curr.h, curr.day + 1));
                box[curr.h][nr][nc] = curr.day + 1;
                visited[curr.h][nr][nc] = true;
            }

            // 상하 탐색
            for (int i = 0; i < 2; i++) {
                int nh = curr.h + dh[i];
                if (nh < 0 || nh >= H || box[nh][curr.r][curr.c] != 0 || visited[nh][curr.r][curr.c]) continue;
                q.add(new Node(curr.r, curr.c, nh, curr.day + 1));
                box[nh][curr.r][curr.c] = curr.day + 1;
                visited[nh][curr.r][curr.c] = true;
            }
        }
    }
}
