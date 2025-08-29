import java.io.*;
import java.util.*;

public class Solution {

    static int N, L;
    static int[] score;
    static int[] cal;
    static int maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 재료 수
            L = Integer.parseInt(st.nextToken()); // 칼로리 제한

            score = new int[N];
            cal = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            maxScore = 0;
            search(0, 0, 0); // idx, 현재 점수합, 현재 칼로리합

            bw.write("#" + t + " " + maxScore + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // idx번째 재료를 선택할지 말지 결정하는 DFS
    static void search(int idx, int scoreSum, int calSum) {
        if (calSum > L) return; // 칼로리 초과 -> 종료
        if (idx == N) { // 모든 재료 고려 끝
            if (scoreSum > maxScore) maxScore = scoreSum;
            return;
        }

        // 1) 현재 재료 선택
        search(idx + 1, scoreSum + score[idx], calSum + cal[idx]);

        // 2) 현재 재료 선택 안 함
        search(idx + 1, scoreSum, calSum);
    }
}
