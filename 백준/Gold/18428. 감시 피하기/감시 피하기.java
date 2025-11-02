import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean result;
    static char[][] grid;
    static List<int[]> teachers;
    static List<int[]> blanks;
    static int[] selected;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        selected = new int[3];

        teachers = new ArrayList<>();
        blanks = new ArrayList<>();

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = st.nextToken().charAt(0);
                if (grid[i][j] == 'T') teachers.add(new int[] {i, j});
                else if (grid[i][j] == 'X') blanks.add(new int[] {i, j});
            }
        }

        // 장애물 세울 위치 고르고 검사
        obstacles(0, 0);

        System.out.println(result ? "YES" : "NO");
    }

    static void obstacles(int idx, int sIdx) {
        if (result) return;

        // 다 골랐다면
        if (sIdx == 3) {
            // 장애물을 세우고
            for (int n : selected) {
                grid[blanks.get(n)[0]][blanks.get(n)[1]] = 'O';
            }

            // 감시를 피할 수 있는지 확인하기
            boolean isOk = true;

            outer:
            for (int[] pos : teachers) {
                for (int d = 0; d < 4; d++) {
                    for (int i = 1; i < N; i++) {
                        int nr = pos[0] + dr[d] * i;
                        int nc = pos[1] + dc[d] * i;

                        // 범위 밖이면 다음 방향으로 넘어가기 위해 break
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
                        if (grid[nr][nc] == 'O') break; // 장애물에 막혔으니 다음 방향으로
                        if (grid[nr][nc] == 'S') {
                            isOk = false;
                            break outer;
                        }
                    }
                }
            }

            // 장애물 원상복구
            for (int n : selected) {
                grid[blanks.get(n)[0]][blanks.get(n)[1]] = 'X';
            }

            // 결과 반환
            result = isOk ? true : false;
            return;
        }

        // 장애물 세울 위치를 고르자
        for (int i = idx; i < blanks.size(); i++) {
            selected[sIdx] = i;
            obstacles(i+1, sIdx+1);
        }
    }
}
