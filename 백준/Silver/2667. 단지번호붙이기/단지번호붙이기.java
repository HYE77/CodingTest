import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] buildings;
    static List<Apt> aptCnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Apt implements Comparable<Apt>{
        int num, cnt;

        public Apt(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Apt o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        // 0이면 건물 아님. 1이 건물임 !!
        buildings = new int[N][N];
        for (int i = 0 ; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                buildings[i][j] = Integer.parseInt(input.charAt(j)+"");
            }
        }

        aptCnt = new ArrayList<>();
        int aptNum = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (buildings[r][c] > 0) {
                    aptCnt.add(new Apt(aptNum, 0));
                    dfs(r, c, aptNum);
                    aptNum++;
                }
            }
        }

        Collections.sort(aptCnt);

        bw.write(aptCnt.size()+"\n");
        for (Apt a : aptCnt) {
            bw.write(a.cnt + "\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int r, int c, int num) {
        // buildings를 깊이우선순회하여 방문 완료된 곳은 0으로 바꾸기
        // aptCnt의 해당 아파트 카운트 +1 처리
        buildings[r][c] = 0;
        aptCnt.get(num-1).cnt++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N || buildings[nr][nc] == 0) continue;
            dfs(nr, nc, num);
        }
    }

}
