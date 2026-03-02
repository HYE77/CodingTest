import java.util.*;
import java.io.*;

public class Main {

    static char[][] grid = new char[5][5];
    static boolean[][] visited;
    static int[] selected = new int[7];
    static boolean[][] isPicked = new boolean[5][5];
    static int ans = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // grid 채우기
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        // 조합 만들기 + 유효한지 확인
        dfs(0, 0, 0);

        System.out.println(ans);
        br.close();
    }

    static void dfs(int idx, int sIdx, int sCnt) {

        if (idx == 7) {
            if (sCnt >= 4) ans += isOk() ? 1 : 0;
            return;
        }

        for (int i = sIdx; i < 25; i++) {
            int newCnt = grid[i/5][i%5] == 'S' ? 1 : 0;
            selected[idx] = i;
            isPicked[i/5][i%5] = true;
            dfs(idx+1, i+1, sCnt + newCnt);
            isPicked[i/5][i%5] = false;
        }
    }

    static boolean isOk() {

        int cnt = 0;
        visited = new boolean[5][5];

        int r = selected[0] / 5;
        int c = selected[0] % 5;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0 || nc >= 5 || nr >= 5 || visited[nr][nc]) continue;

                if (isPicked[nr][nc]) {
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        return cnt == 7;
    }
}