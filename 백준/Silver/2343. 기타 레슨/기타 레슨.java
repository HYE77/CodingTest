 import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int max = 0, sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 영상 개수
        int M = Integer.parseInt(st.nextToken()); // 블루레이 개수

        // 블루레이 배열 완성하기
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 영상의 합과 최대 길이 찾기
        for (int n : arr) {
            max = Math.max(max, n);
            sum += n;
        }

        // 이분 탐색으로 블루레이 크기의 최소를 찾아보자
        if (N <= M) {
            bw.write(max+"");
        } else {
            int left = max;
            int right = sum;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (cal(mid) > M) left = mid + 1;
                else right = mid - 1;
            }

            bw.write(left+"");

        }


        bw.flush();
        br.close();
        bw.close();
    }

    static int cal(int size) {
        // 블루레이 크기가 size일 때 블루레이 개수 반환
        int cnt = 0; // 블루레이 개수
        int idx = 0; // 순회 인덱스
        while (idx < arr.length) {
            int tmpSum = 0;
            int tmpIdx = idx;
            if (size < arr[tmpIdx]) return -1; // 블루레이 크기가 영상 하나의 길이보다 짧으면 안 됨
            tmpSum += arr[tmpIdx];
            while (tmpIdx+1 < arr.length && tmpSum + arr[tmpIdx+1] <= size) { // 다음 영상도 넣을 수 있을 때
                tmpIdx++;
                tmpSum += arr[tmpIdx];
            }
            cnt++;
            idx = tmpIdx+1;
        }

        return cnt;

    }

}
