
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			Map<Integer, Integer> map = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(br.readLine());
				int value = map.getOrDefault(tmp, 0);
				map.put(tmp, ++value);
			}
			
			List<Integer> keyList = new ArrayList<>(map.keySet());
			Collections.sort(keyList);
			
			int ansNum = -1;
			int maxCnt = -1;
			for (int num : keyList) {
				if (map.get(num) > maxCnt) {
					ansNum = num;
					maxCnt = map.get(num);
				}
			}
			
			bw.write(ansNum+"\n");
					
		}
				
		bw.flush();
		br.close();
		bw.close();
	}

}