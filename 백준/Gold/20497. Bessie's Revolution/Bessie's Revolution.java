import java.io.*;
        import java.util.*;

public class Main {

    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static List<int[]> positions;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        positions = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == '.') positions.add(new int[] {i, j});
            }
        }

        // 원본 구역 수 확인
        visited = new boolean[N][N];
        int totalGroup = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '.' && !visited[i][j]) {
                    bfs(i, j);
                    totalGroup++;
                }
            }
        }

        // brute force 탐색 시작
        int ans = 0;

        for (int[] pos : positions) {
            grid[pos[0]][pos[1]] = '@'; // 잠복하기

            // 부분 격자 개수 확인
            visited = new boolean[N][N];
            visited[pos[0]][pos[1]] = true;

            int group = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == '.' && !visited[i][j]) {
                        bfs(i, j);
                        group++;
                    }
                }
            }

            // 확인하기
            if (group > totalGroup) ans++;

            // 원상복구
            grid[pos[0]][pos[1]] = '.';
        }

        System.out.println(ans);
    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr >= 0 && nc >= 0 && nr < N && nc < N
                        && grid[nr][nc] == '.' && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
}
