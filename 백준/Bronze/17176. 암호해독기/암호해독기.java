
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> nums = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		char[] chars= br.readLine().toCharArray();
		List<Integer> decode = new ArrayList<>();
		
		for (char c : chars) {
			int target;
			if (c >= 'A' && c <= 'Z') {
				target = c - 64;
			} else if (c >= 'a' && c <= 'z') {
				target = c - 70;
				
			} else {
				target = 0;
			}
			
			decode.add(target);
		}
		
		Collections.sort(nums);
		Collections.sort(decode);
		
		boolean possible = true;
		for (int i = 0; i < N; i++) {
			if (decode.get(i) != nums.get(i)) possible = false;
		}
		
		bw.write(possible ? "y" : "n");
				
		bw.flush();
		br.close();
		bw.close();
	}

}