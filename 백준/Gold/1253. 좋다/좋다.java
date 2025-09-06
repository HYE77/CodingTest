import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 탐색 시작 ..
        int ans = 0;
        for (int i = 0; i < N; i++) { // i번째 숫자가 GOOD인지 확인
            boolean isGood = false;
            for (int j = 0; j < N; j++) { // j : 빼서 비교할 값의 인덱스
                if (i == j) continue;

                int target = arr[i] - arr[j]; // 배열에 target 값이 있는지 찾아야 함

                int left = 0;
                int right = N - 1;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (arr[mid] == target) {
                        if (mid != i && mid != j) {
                            isGood = true;
                            break;
                        } else {
                            // 양 옆으로 같은 값 있는지 확인
                            int l = mid - 1;
                            int r = mid + 1;
                            while (l >= 0 && arr[l] == target) {
                                if (l != i && l != j) isGood = true;
                                l--;
                            }
                            while (r < N && arr[r] == target) {
                                if (r != i && r != j) isGood = true;
                                r++;
                            }
                        }
                        break;
                    } else if (target > arr[mid]) left = mid + 1;
                    else right = mid - 1;
                }
            }
            if (isGood) {
                ans++;
            }

        }

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }

}
