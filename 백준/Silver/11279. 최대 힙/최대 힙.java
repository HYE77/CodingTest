import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 입력 개수

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0 && pq.isEmpty()) bw.write("0\n");
            else if (tmp == 0 && !pq.isEmpty()) bw.write(-pq.poll()+"\n");
            else pq.add(-tmp);
        }


        bw.flush();
        br.close();
        bw.close();
    }

}