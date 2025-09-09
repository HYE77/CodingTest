import java.util.*;
import java.io.*;

public class Main {

    static class Num implements Comparable<Num> {
        int origin, abs;

        public Num(int origin, int abs) {
            this.origin = origin;
            this.abs = abs;
        }

        @Override
        public int compareTo(Num o) {
            if (this.abs == o.abs) return this.origin - o.origin;
            return this.abs - o.abs;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 입력 개수

        PriorityQueue<Num> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            Num tmpNum = new Num(tmp, Math.abs(tmp));
            if (tmp == 0 && pq.isEmpty()) bw.write("0\n");
            else if (tmp == 0 && !pq.isEmpty()) bw.write(pq.poll().origin +"\n");
            else pq.add(tmpNum);
        }


        bw.flush();
        br.close();
        bw.close();
    }

}