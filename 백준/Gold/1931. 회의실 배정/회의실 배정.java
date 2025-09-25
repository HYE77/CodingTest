import java.util.*;
import java.io.*;

public class Main {
	
	static int N, ans;
	
	static class Ref implements Comparable<Ref>{
		int start, end;

		public Ref(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Ref o) {
			if (o.end == this.end) return this.start - o.start;
			return this.end - o.end;
		}

		@Override
		public String toString() {
			return "Ref [start=" + start + ", end=" + end + "]";
		}		
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Ref> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	pq.add(new Ref(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        int endTime = pq.poll().end;
        ans++;
        
        while (!pq.isEmpty()) {
        	Ref curr = pq.poll();
        	if (curr.start < endTime) continue;
        	endTime = curr.end;
        	ans++;
        }
        
        bw.write(ans+"");
        
        bw.flush();
        br.close();
        bw.close();
    }
}
