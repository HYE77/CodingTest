import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 남은 일수
        int M = Integer.parseInt(st.nextToken()); // 목표 가산점

        int[] volunteer = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) volunteer[i] = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 헌혈 가산점
        int D = Integer.parseInt(st.nextToken()); // 헌혈 후 휴식 기간

        // dp[k][i]: 특별 활동을 k번 했을 때, i일차에 가질 수 있는 최대 점수
        // k는 최대 N번까지 가능 (넉넉하게 N+1)
        // i는 N일까지 (D일로 인해 N을 초과하는 경우는 모두 N일째로 처리)
        int[][] dp = new int[N + 1][N + 1];

        // 도달할 수 없는 상태를 표시하기 위해 -1로 초기화
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0; // 0번 활동, 0일차 점수는 0

        for (int k = 0; k <= N; k++) {
            for (int i = 0; i < N; i++) {
                if (dp[k][i] == -1) continue;

                // 1. 일반 활동 선택: 오늘 점수 volunteer[i]를 얻고 i+1일로 이동
                dp[k][i + 1] = Math.max(dp[k][i + 1], dp[k][i] + volunteer[i]);

                // 2. 특별 활동 선택: k+1번 활동, A 점수를 얻고 i+D일로 이동
                // 단, 특별 활동은 k < N일 때만 가능 (dp 배열 크기 내)
                if (k < N) {
                    int nextDay = Math.min(N, i + D);
                    dp[k + 1][nextDay] = Math.max(dp[k + 1][nextDay], dp[k][i] + A);
                }
            }
        }

        // 결과 탐색: k를 0부터 늘려가며 dp[k][N]이 목표치 M 이상인지 확인
        int result = -1;
        for (int k = 0; k <= N; k++) {
            if (dp[k][N] >= M) {
                result = k;
                break;
            }
        }

        System.out.println(result);
    }
}