import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] checkRow, checkCol, checkSquare, usedDomino;
    static int[] dr = {0, 1}; // 우측, 아래 방향만 체크 (중복 방지)
    static int[] dc = {1, 0};
    static boolean finish;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[9][9];
            checkRow = new boolean[9][10];
            checkCol = new boolean[9][10];
            checkSquare = new boolean[9][10];
            usedDomino = new boolean[10][10];
            finish = false;

            // 1. 도미노 정보 입력
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                String uPos = st.nextToken();
                int v = Integer.parseInt(st.nextToken());
                String vPos = st.nextToken();
                
                place(uPos.charAt(0) - 'A', uPos.charAt(1) - '1', u);
                place(vPos.charAt(0) - 'A', vPos.charAt(1) - '1', v);
                usedDomino[u][v] = usedDomino[v][u] = true;
            }

            // 2. 고정 숫자(1~9) 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 9; i++) {
                String pos = st.nextToken();
                place(pos.charAt(0) - 'A', pos.charAt(1) - '1', i);
            }

            sb.append("Puzzle ").append(tc++).append("\n");
            solve(0);
        }
        System.out.print(sb);
    }

    // 숫자를 그리드에 배치하고 체크 배열 갱신
    static void place(int r, int c, int num) {
        map[r][c] = num;
        checkRow[r][num] = true;
        checkCol[c][num] = true;
        checkSquare[(r / 3) * 3 + (c / 3)][num] = true;
    }

    // 숫자 제거 (백트래킹용)
    static void remove(int r, int c, int num) {
        map[r][c] = 0;
        checkRow[r][num] = false;
        checkCol[c][num] = false;
        checkSquare[(r / 3) * 3 + (c / 3)][num] = false;
    }

    static void solve(int idx) {
        if (finish) return;

        // 모든 칸을 다 채운 경우
        if (idx == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) sb.append(map[i][j]);
                sb.append("\n");
            }
            finish = true;
            return;
        }

        int r = idx / 9;
        int c = idx % 9;

        // 이미 채워진 칸이면 다음 칸으로
        if (map[r][c] != 0) {
            solve(idx + 1);
            return;
        }

        // 현재 칸에 숫자 i를 시도
        for (int i = 1; i <= 9; i++) {
            if (!canPlace(r, c, i)) continue;

            // 인접한 칸(우측/아래)에 숫자 j를 시도하여 도미노 완성
            for (int d = 0; d < 2; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 9 || nc >= 9 || map[nr][nc] != 0) continue;

                for (int j = 1; j <= 9; j++) {
                    if (i == j || usedDomino[i][j] || !canPlace(nr, nc, j)) continue;

                    // 도미노 배치
                    place(r, c, i);
                    place(nr, nc, j);
                    usedDomino[i][j] = usedDomino[j][i] = true;

                    solve(idx + 1);

                    // 백트래킹 (원상복구)
                    usedDomino[i][j] = usedDomino[j][i] = false;
                    remove(nr, nc, j);
                    remove(r, c, i);
                    
                    if (finish) return;
                }
            }
        }
    }

    static boolean canPlace(int r, int c, int num) {
        return !checkRow[r][num] && !checkCol[c][num] && !checkSquare[(r / 3) * 3 + (c / 3)][num];
    }
}