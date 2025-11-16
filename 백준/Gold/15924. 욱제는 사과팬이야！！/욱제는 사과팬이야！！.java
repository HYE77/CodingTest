import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // E라면 오른쪽, S라면 아래, B라면 아래 or 오른쪽
        // 목적지는 (N, M)

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int MOD = 1_000_000_009;

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
//
//        char[][] grid2 = new char[N][M];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                // grid[0][0] 일 때
//                if (i == 0 && j == 0) continue;
//
//                if (i == 0) { // 첫 행일 때 -> 왼쪽 칸만 고려
//                    if (grid[i][j-1] == 'E' || grid[i][j-1] == 'B') grid2[i][j] = 'L';
//                    continue;
//                }
//
//                if (j == 0) { // 첫 열일 때 -> 위쪽 칸만 고려
//                    if (grid[i-1][j] == 'S' || grid[i-1][j] == 'B') grid2[i][j] = 'U';
//                    continue;
//                }
//
//                // 나머지 -> 왼쪽, 위쪽 다 고려
//                boolean cond1 = grid[i-1][j] == 'S' || grid[i-1][j] == 'B';
//                boolean cond2 = grid[i][j-1] == 'E' || grid[i][j-1] == 'B';
//                if (cond1 && cond2) grid2[i][j] = 'B';
//                else if (cond1) grid2[i][j] = 'U';
//                else if (cond2) grid2[i][j] = 'L';
//            }
//        }

        // DP
        int[][] dp = new int[N][M];
        for (int[] row : dp) {
            Arrays.fill(row, 1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                switch (grid[i][j]) {
                    case 'E':
                        if (j+1 < M) dp[i][j+1] += dp[i][j] % MOD;
                        break;
                    case 'S':
                        if (i+1 < N) dp[i+1][j] += dp[i][j] % MOD;
                        break;
                    case 'B':
                        if (j+1 < M) dp[i][j+1] += dp[i][j] % MOD;
                        if (i+1 < N) dp[i+1][j] += dp[i][j] % MOD;
                        break;
                }
            }
        }

        System.out.println(dp[N-1][M-1] % MOD);
        br.close();
    }
}