import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] orgn = new int[N];
		int[] sorted = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			orgn[i] = sorted[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(sorted);
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int rank = 0;
		for (int num : sorted) {
			if (!map.containsKey(num)) {
				map.put(num,  rank++);
			}
		}
		
		for (int num : orgn) {
			bw.write(map.get(num) + " ");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}

}