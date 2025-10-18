import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] grid;
    static boolean[][] visited;
    static List<int[]> firePos;
    static int[] JH;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        visited = new boolean[R][C];
        firePos = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = input.charAt(j);
                if (grid[i][j] == 'J') JH = new int[] {i, j};
                if (grid[i][j] == 'F') firePos.add(new int[] {i, j});
                if (grid[i][j] == '#') visited[i][j] = true;
            }
        }

        boolean isPossible = false;
        int ans = -1;

        Queue<int[]> q = new ArrayDeque<>();

        for (int[] f : firePos) {
            q.add(new int[] {f[0], f[1], 1, 1});
            visited[f[0]][f[1]] = true;
        }
        q.add(new int[] {JH[0], JH[1], 1, 0}); // index 3 -> 0=지훈 / 1=불
        visited[JH[0]][JH[1]] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            // 도달 확인
            if (cur[3] == 0 && (cur[0] == 0 || cur[1] == 0 || cur[0] == R-1 || cur[1] == C-1)) {
                isPossible = true;
                ans = cur[2];
                break;
            }

            // 다음 이동
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc]) continue;
                q.add(new int[] {nr, nc, cur[2]+1, cur[3]});
                visited[nr][nc] = true;
            }
        }

        bw.write(isPossible ? ans+"" : "IMPOSSIBLE");
        bw.flush();
        br.close();
        bw.close();
    }
}
