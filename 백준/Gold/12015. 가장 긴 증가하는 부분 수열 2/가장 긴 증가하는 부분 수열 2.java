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
        
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (lis.isEmpty() || lis.get(lis.size()-1) < arr[i]) lis.add(arr[i]);
            else {
                int idx = Collections.binarySearch(lis, arr[i]);
                if (idx < 0) idx = -idx - 1;
                lis.set(idx, arr[i]);

            }
        }

        System.out.println(lis.size());
        br.close();
    }
}



