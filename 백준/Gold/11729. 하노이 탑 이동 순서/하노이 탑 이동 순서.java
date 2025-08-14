import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
				
		hanoi(N, 1, 3, 2, sb);
		
		bw.write(cnt + "\n");
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void hanoi(int N, int from, int to, int temp, StringBuilder sb) {
		if (N==0) return;
		
		hanoi(N-1, from, temp, to, sb);
		sb.append(from+" ").append(to+"\n");
		cnt += 1;
		hanoi(N-1, temp, to, from, sb);
	}
}