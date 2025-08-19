 import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int curr = arr[0];
        int increaseMax = 0;
        int decreaseMax = 0;
        int currMax = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] >= curr) {
                currMax++;
            } else {
                increaseMax = Math.max(currMax, increaseMax);
                currMax = 1;
            }
            curr = arr[i];
        }
        increaseMax = Math.max(currMax, increaseMax);


        curr = arr[0];
        currMax = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] <= curr) {
                currMax++;
            } else {
                decreaseMax = Math.max(currMax, decreaseMax);
                currMax = 1;
            }
            curr = arr[i];
        }
        decreaseMax = Math.max(currMax, decreaseMax);

        int max = Math.max(decreaseMax, increaseMax);

        bw.write(max+"");
        bw.flush();
        br.close();
        bw.close();

    }

}
