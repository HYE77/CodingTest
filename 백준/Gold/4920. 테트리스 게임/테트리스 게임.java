import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] grid;
    static int[][] first = {{-1, -1}, {-1, 0}, {0, 2}, {1, 0}, {1, 1}}; // 가운데 칸 기준
    static int[][] second = {{-1, 0}, {0, 1}, {1, -1}, {1, 1}, {2, -1}}; // 맨 위칸 기준
    static int[][][] third = {{{1, 0}, {1, 1}}, {{-1, 0}, {1, -1}}, {{1, -1}, {1, 0}}}; // 오른쪽 칸 기준

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = 1;
        while ((N = Integer.parseInt(br.readLine().trim())) != 0) {
            grid = new int[N][N];

            // grid 생성
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = Integer.MIN_VALUE;
            // max 계산(1) - 가로 세 칸에 한 칸 붙이기
            for (int r = 0; r < N; r++) {
                for (int c = 1; c < N-1; c++) {
                    int tmp = grid[r][c-1] + grid[r][c] + grid[r][c+1];
                    for (int d = 0; d < 5; d++) {
                        int nr = r + first[d][0];
                        int nc = c + first[d][1];

                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                        max = Math.max(tmp + grid[nr][nc], max);
                    }
                }
            }

            // max 계산(2) - 세로 세 칸에 한 칸 붙이기
            for (int r = 0; r < N-2; r++) {
                for (int c = 0; c < N; c++) {
                    int tmp = grid[r][c] + grid[r+1][c] + grid[r+2][c];
                    for (int d = 0; d < 5; d++) {
                        int nr = r + second[d][0];
                        int nc = c + second[d][1];

                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                        max = Math.max(tmp + grid[nr][nc], max);
                    }
                }
            }

            // max 계산(3) - 나머지
            for (int r = 0; r < N; r++) {
                for (int c = 1; c < N; c++) {
                    int tmp = grid[r][c-1] + grid[r][c];
                    for (int[][] pos : third) {
                        int nr1 = r + pos[0][0];
                        int nc1 = c + pos[0][1];
                        if (nr1 < 0 || nc1 < 0 || nr1 >= N || nc1 >= N) continue;

                        int nr2 = r + pos[1][0];
                        int nc2 = c + pos[1][1];
                        if (nr2 < 0 || nc2 < 0 || nr2 >= N || nc2 >= N) continue;

                        max = Math.max(tmp + grid[nr1][nc1] + grid[nr2][nc2], max);
                    }
                }
            }

            System.out.println(t + ". " + max);
            t++;
        }

        br.close();
    }
}