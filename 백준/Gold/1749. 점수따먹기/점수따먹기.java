import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] grid = new long[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] cumSum = new long[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                cumSum[i][j] = cumSum[i-1][j] + cumSum[i][j-1] + grid[i-1][j-1] - cumSum[i-1][j-1];
            }
        }

        // i, j -> 부분 행렬의 오른쪽 아래 좌표
        long ans = Long.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // 부분 행렬 탐색
                for (int r = 0; r < i; r++) {
                    for (int c = 0; c < j; c++) {
                        long temp = cumSum[i][j] - cumSum[r][j] - cumSum[i][c] + cumSum[r][c];
                        ans = Math.max(temp, ans);
                    }
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}