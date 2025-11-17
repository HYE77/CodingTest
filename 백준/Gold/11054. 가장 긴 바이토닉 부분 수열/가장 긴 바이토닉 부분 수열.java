import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] lis = new int[N]; // 증가 부분
        int[] lds = new int[N]; // 감소 부분
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        // LIS
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // LDS
        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, lis[i] + lds[i] - 1);
        }

        System.out.println(ans);
        br.close();
    }
}