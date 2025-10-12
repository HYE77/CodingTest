import java.io.*;
import java.util.*;

public class Main {

    static class Meet implements Comparable <Meet>{
        int start, end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet o) {
            // 일찍 끝나는 회의부터 뽑기
            if (this.start == o.start) return this.end - o.end;
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Meet> pq = new PriorityQueue<>();
        int[] rooms = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Meet(start, end));
        }

        while (!pq.isEmpty()) {
            Meet curr = pq.poll();

            for (int idx = 0; idx < N; idx++) {
                if (rooms[idx] <= curr.start) {
                    rooms[idx] = curr.end;
                    break;
                }
            }
        }

        int cnt = 0;
        for (int n : rooms) {
            cnt += n > 0 ? 1 : 0;
        }

        bw.write(cnt+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
