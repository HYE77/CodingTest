import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] grid;
    static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // grid size
        M = Integer.parseInt(st.nextToken()); // cmd cnt

        // grid 채우기
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기화 + cmd 입력받고 비바라기 시전
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] wasCloud = new boolean[N][N];
        q.add(new int[] {N-1, 0});
        q.add(new int[] {N-1, 1});
        q.add(new int[] {N-2, 0});
        q.add(new int[] {N-2, 1});

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()); // 방향
            int s = Integer.parseInt(st.nextToken()); // 거리

            // 구름 이동
            while (!q.isEmpty()) {
                int[] cur = q.poll();

                int nr = (N*s + (cur[0] + dr[d] * s)) % N;
                int nc = (N*s + (cur[1] + dc[d] * s)) % N;

                grid[nr][nc]++;
                wasCloud[nr][nc] = true;
            }

            // 물복사 버그
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (wasCloud[r][c]) {
                        int cnt = 0;

                        // 대각선 칸 중 물이 있는 바구니 카운트
                        for (int dir = 2; dir < 9; dir += 2) {
                            int nr = r + dr[dir];
                            int nc = c + dc[dir];

                            if (nr >= 0 && nc >= 0 && nr < N && nc < N && grid[nr][nc] > 0) cnt++;
                        }

                        grid[r][c] += cnt;
                    }
                }
            }

            // 구름 생성
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (grid[r][c] >= 2 && !wasCloud[r][c]) {
                        grid[r][c] -= 2;
                        q.add(new int[] {r, c});
                    }
                }
            }

            // 다음 cmd를 위한 초기화
            for(boolean[] row : wasCloud) Arrays.fill(row, false);
        }

        // 물의 양 구하기
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += grid[i][j];
            }
        }

        System.out.println(ans);
    }
}