import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] seat;
    static List<Integer> stdList = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Integer>[] bffList;

    static class Pos implements Comparable<Pos>{

        int near, empty, row, col;

        public Pos(int near, int empty, int row, int col) {
            this.near = near;
            this.empty = empty;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.near != o.near) return o.near - this.near;
            if (this.empty != o.empty) return o.empty - this.empty;
            if (this.row != o.row) return this.row - o.row;
            return this.col - o.col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        seat = new int[N][N];

        // 각 학생 정보 저장
        bffList = new List[N*N+1];
        for (int i = 1; i <= N*N; i++) {
            bffList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            stdList.add(num);

            for (int j = 0; j < 4; j++) {
                bffList[num].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 한 명 씩 배치시키자
        List<Pos> posList;
        for (int i = 0; i < N*N; i++) {
            posList = new ArrayList<>();
            int stdNum = stdList.get(i);

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (seat[r][c] > 0) continue; // 이미 선점된 자리라면 지나치기

                    // 차지할 수 있는 자리라면 네 방향 탐색
                    int cnt = 0;
                    int blank = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        // 만약 좌석이 범위 내에 존재하고, 그 자리에 앉은 사람이 내가 좋아하는 학생이라면
                        if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                            if (seat[nr][nc] == 0) blank++;
                            else if (bffList[stdNum].contains(seat[nr][nc])) cnt++;
                        }
                    }

                    posList.add(new Pos(cnt, blank, r, c));
                }
            }

            // 가장 조건에 부합한 자리에 앉히기
            Collections.sort(posList);
            int tmpR = posList.get(0).row;
            int tmpC = posList.get(0).col;
            seat[tmpR][tmpC] = stdNum;
        }

        // 만족도의 합을 구하자
        // 0명 -> 0, 1명 -> 1, 2명 -> 10, 3명 -> 100, 4명 -> 1000
        int ans = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int cnt = 0;

                // 네 방향 탐색
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr >= 0 && nc >= 0 && nr < N && nc < N
                            && bffList[seat[r][c]].contains(seat[nr][nc])) cnt++;
                }

                if (cnt > 0) ans += (int) Math.pow(10, cnt-1);
            }
        }

        System.out.println(ans);
        br.close();
    }
}