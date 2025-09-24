import org.w3c.dom.Node;

import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int answer = -1;
    static boolean[][] visited;
    static int[][] box;
    static List<int[]> good;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Tomato {
        int r, c, day;

        public Tomato(int r, int c, int day) {
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[M][N];
        visited = new boolean[M][N];

        good = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) good.add(new int[] {i, j});
                else if (box[i][j] == -1) visited[i][j] = true;
            }
        }

        bfs();

        boolean bad = false;
        for (boolean[] row : visited) {
            for (boolean v : row) {
                if (!v) {
                    bad = true;
                    break;
                }
            }
            if (bad) break;
        }

        bw.write(bad ? "-1" : answer+"");


        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs() {

        Queue<Tomato> q = new ArrayDeque<>();

        for (int[] tomato : good) {
            q.add(new Tomato(tomato[0], tomato[1], 0));
            visited[tomato[0]][tomato[1]] = true;
        }


        while (!q.isEmpty()) {
            Tomato curr = q.poll();
            answer = curr.day;

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= M || nc >= N || visited[nr][nc]) continue;
                q.add(new Tomato(nr, nc, curr.day + 1));
                visited[nr][nc] = true;

            }
        }
    }
}
