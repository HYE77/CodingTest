import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> lst = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int move = Integer.parseInt(st.nextToken()); // 이동 입력
			lst.add(i-1-move, i);
		}
		
		for (int num : lst) {
			bw.write(num + " ");
		}
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}

}
