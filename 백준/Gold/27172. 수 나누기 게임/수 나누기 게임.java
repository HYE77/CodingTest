import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 내 숫자로 너의 숫자가 나누어떨어지면 내가 이. 둘 다 아니라면 무승부 -> 변화 없음.
        int N = Integer.parseInt(br.readLine());
        int[] pos = new int[1000001];
        int[] arr = new int[N];
        Arrays.fill(pos, -1);
        int[] score = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            pos[n] = i;
            arr[i] = n;
        }

        // game start
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int k = 1;
            while (num * k <= 1000000) {
                if (pos[num*k] > -1) {
                    score[pos[num*k]]--;
                    score[i]++;
                }

                k++;
            }
        }

        for (int n : score) System.out.print(n + " ");
        br.close();
    }
}