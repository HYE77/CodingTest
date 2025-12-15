import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        // 1. 백을 선택
        // 2. 흑을 선택
        // 3. 둘 다 선택하지 않음

        int[][] P = new int[1001][2];
        int[][][] dp = new int[1001][16][16];
        // dp[i][j][k] = max(dp[i-1][j-1][k] + P[i][0], dp[i-1][j][k-1]+P[i][1], dp[i-1][i][j])

        int max_idx = 15; // 한 팀 최대 인원 15명

        int cnt = 0; // 입력 인원 수

        // 입력 받기
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            P[cnt][0] = sc.nextInt(); // 백
            P[cnt][1] = sc.nextInt(); // 흑
            cnt++;
        }

        dp[0][1][0] = P[0][0]; // 첫번째 플레이어 -> 백
        dp[0][0][1] = P[0][1]; // 첫번째 플레이어 -> 흑

        int max = -1; // 능력치

        for(int i = 1; i < cnt; i++) { // 전체 인원을 순회하는 변수 i
            for(int j = 0; j <= max_idx; j++) { // 백팀에 선발된 인원 수
                for(int k = 0; k <= max_idx; k++) { // 흑팀에 선발된 인원 수

                    int tmp1 = 0, tmp2 = 0;

                    // 현재 플레이어가 백팀으로 들어갈 경우
                    if (j > 0) tmp1 = dp[i-1][j-1][k] + P[i][0];
                    
                    // 현재 플레이어가 흑팀으로 들어갈 경우
                    if (k > 0) tmp2 = dp[i-1][j][k-1] + P[i][1];

                    // 세 가지 경우 중 가장 큰 값을 넣어줌
                    dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(tmp1, tmp2)); 

                    // 15명까지 다 비교해봤다면 최댓값 저장하기
                    if (j == max_idx && k == max_idx) {
                        max = Math.max(max, dp[i][j][k]);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
