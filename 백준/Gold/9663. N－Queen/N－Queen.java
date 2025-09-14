import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int ans = 0;
    static int[][] board;
    static int[] dc = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        NQueen(0);

        bw.write(ans+"");

        bw.flush();
        br.close();
        bw.close();
    }

    static void NQueen(int r) {
        // 다 채웠으면 카운트 업
        if (r == N) {
            ans++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isOk(r, col)) {
                board[r][col] = 1;
                NQueen(r+1);
                board[r][col] = 0;
            }
        }

    }

    static boolean isOk(int r, int c) {
        // 지금 행에 넣을 수 있는지 확인 (위쪽 겹치는 거 확인)
        boolean possible = true;

        for (int k = 1; k <= r; k++) { // k번 위로 올라가며 확인
            for (int d = 0; d < 3; d++) {
                int nr = r + (-1) * k;
                int nc = c + dc[d] * k;

                // 범위 밖이거나 겹치는 위치가 있다면 지나쳐
                if (nc >= 0 && nc < N && board[nr][nc] == 1) {
                    possible = false;
                    break;
                }

            }
            if (!possible) break;
        }

        return possible;
    }


}
