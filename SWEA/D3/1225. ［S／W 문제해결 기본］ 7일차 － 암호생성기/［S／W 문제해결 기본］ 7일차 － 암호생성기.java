import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            int n = 1;
            while (true) {
                int item = Math.max(q.poll() - (n % 6), 0);
                q.offer(item);

                if (item == 0) break;
                n++;
                if (n % 6 == 0) n++;
            }

            System.out.print("#" + t + " ");
            for (int num : q) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}