import java.util.*;
import java.io.*;

public class Solution {

    static int minGap;
    static int[][] synergy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine()); // 식재료 개수
            synergy = new int[N][N];
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < N; m++) {
                    synergy[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            minGap = Integer.MAX_VALUE;
            comb(1, N, new ArrayList<>());

            bw.write("#" + t + " " + minGap + "\n");


        }


        bw.flush();
        br.close();
        bw.close();

    }

    public static void comb(int idx, int N, ArrayList<Integer> selected) {
        // N 중에 N/2개 고르기
        if (selected.size() == N/2) {
            minGap = Math.min(minGap, calSynergy(selected));
            return;
        }

        for (int i = idx; i <= N; i++) {
            selected.add(i);
            comb(i + 1, N, selected); // 다음 원소부터 탐색
            selected.remove(selected.size() - 1); // 백트래킹
        }
    }

    public static int calSynergy(ArrayList<Integer> selected) {
        int len = selected.size();

        int sum1 = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                int a = selected.get(i);
                int b = selected.get(j);
                sum1 += synergy[a-1][b-1] + synergy[b-1][a-1];
            }
        }

        int sum2 = 0;
        ArrayList<Integer> unselected = new ArrayList<>();
        for (int i = 1; i <= len*2; i++) {
            if (!selected.contains(i)) unselected.add(i);
        }

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                int a = unselected.get(i);
                int b = unselected.get(j);
                sum2 += synergy[a-1][b-1] + synergy[b-1][a-1];
            }
        }

        return Math.abs(sum1-sum2);
    }



}