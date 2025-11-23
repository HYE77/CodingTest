import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int length = 0;
        int[] tail = new int[N];
        int[] tailIdx  = new int[N];
        int[] prev = new int[N];

        for (int i = 0; i < N; i++) {

            // 이분탐색으로 삽입할 인덱스 고르기
            int pos = Arrays.binarySearch(tail, 0, length, arr[i]);

            if (pos < 0) pos = -pos -1;

            tail[pos] = arr[i];
            tailIdx[pos] = i;

            if (pos > 0) prev[i] = tailIdx[pos - 1]; // LIS의 바로 전 숫자의 인덱스 저장

            if (pos == length) length++; // 가장 마지막에 추가되었다면 길이 늘리기
        }

        // LIS 복원
        int[] lis = new int[length];
        int k = tailIdx[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            lis[i] = arr[k];
            k = prev[k];
        }

        System.out.println(length);

        for (int n : lis) {
            System.out.print(n+" ");
        }
        
        br.close();
    }
}

