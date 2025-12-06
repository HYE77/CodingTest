import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보드판 한 변
        int M = Integer.parseInt(st.nextToken()); // 블록 개수

        int[][] board = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            board[x][y]++;
        }

        // 구간 누적합 배열 생성
        int[][] cumSum = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                cumSum[i][j] = cumSum[i-1][j] + cumSum[i][j-1] + board[i-1][j-1] - cumSum[i-1][j-1];
            }
        }

        // 구간에 2층 이상인 곳이 몇 개 있는지 확인
        int[][] over = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                over[i][j] = over[i-1][j] + over[i][j-1] + Math.max(board[i-1][j-1]-1, 0) - over[i-1][j-1];
            }
        }

        // 가능한 변의 개수 구하기
        List<Integer> lst = new ArrayList<>();
        for (int n = 1; n <= M && n <= N; n++) {
            if (M % n == 0) lst.add(n);
        }

        // 찾아보자
        int minMove = Integer.MAX_VALUE;
        for (int len : lst) {
            int len2 = M / len; // 다른 한 변
            for (int i = len; i <= N; i++) {
                for (int j = len2; j <= N; j++) {
                    int temp = cumSum[i][j] - cumSum[i-len][j] - cumSum[i][j-len2] + cumSum[i-len][j-len2];
                    int additional = over[i][j] - over[i-len][j] - over[i][j-len2] + over[i-len][j-len2];

                    minMove = Math.min(minMove, M-temp+additional);
                }
            }
        }

        System.out.println(minMove);
        br.close();
    }
}
