import java.io.*;
import java.util.*;

public class Main {

    static int N, M, cheeseCnt, soonMelt, time;
    static int[][] cheese;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j] == 1) cheeseCnt++;
            }
        }

        time = 0;
        Queue<int[]> q;
        visited = new boolean[N][M];

        while (true) {
            time++;
            soonMelt = 0;
            for (boolean[] line : visited) Arrays.fill(line, false);

            q = new ArrayDeque<>();
            q.add(new int[] {0, 0});
            visited[0][0] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;

                    if (cheese[nr][nc] == 0) {
                        q.add(new int[] {nr, nc});
                        visited[nr][nc] = true;
                        continue;
                    }

                    if (cheese[nr][nc] == 1) {
                        cheeseCnt--;
                        soonMelt++;
                        cheese[nr][nc] = 0;
                        visited[nr][nc] = true;
                    }
                }
            }

            if (cheeseCnt == 0) break;
        }

        System.out.println(time);
        System.out.println(soonMelt);
        br.close();
    }
}