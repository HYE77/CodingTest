import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 집합 S
		int M = Integer.parseInt(st.nextToken()); // 
		
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		int sum = 0;
		
		for (int i = 0; i < M; i++) {
			if (set.contains(br.readLine())) sum++;
			
		}
		
		bw.write(sum+"");
		
		bw.flush();
		bw.close();
		br.close();
	}

}