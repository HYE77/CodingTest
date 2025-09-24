import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0, maxLen = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int right = 0; right < N; right++) {
			int tmp = arr[right];
			
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			
			while (map.size() > 2) {
				int leftInt = arr[left++];
				map.put(leftInt, map.get(leftInt) - 1);
				
				if (map.get(leftInt) == 0) map.remove(leftInt);
			}
			maxLen = Math.max(maxLen, right - left + 1);	
		}
		
		bw.write(maxLen+"");
		
		
		bw.flush();
		br.close();
		bw.close();
	}
}
