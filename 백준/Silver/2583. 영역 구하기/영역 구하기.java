import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static boolean[][] grid;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    grid[y][x] = true;
                }
            }
        }

        int ans = 0;
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!grid[i][j]) {
                    lst.add(bfs(i, j));
                    ans++;
                }
            }
        }

        Collections.sort(lst);

        System.out.println(ans);
        for (int n : lst) {
            System.out.print(n+" ");
        }
        br.close();
    }

    static int bfs(int x, int y) {
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        grid[x][y] = true;
        count++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr >= 0  && nc >= 0 && nr < N && nc < M && !grid[nr][nc]) {
                    q.add(new int[] {nr, nc});
                    grid[nr][nc] = true;
                    count++;
                }
            }
        }

        return count;
    }
}

