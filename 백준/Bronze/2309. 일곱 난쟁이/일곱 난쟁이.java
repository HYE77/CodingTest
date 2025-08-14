import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Integer[] arr = new Integer[9];
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			sum += num;
		}
		
		int gap = sum - 100;
		
		Set<Integer> set = new TreeSet<>(Arrays.asList(arr));
		
		boolean isOk = true; 
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i != j && arr[i] + arr[j] == gap) {
					set.remove(arr[i]);
					set.remove(arr[j]);
					isOk = false;
					break;
				}
			}
			if (!isOk) break;
		}
		
		for (Integer num : set) {
			bw.write(num + "\n");
		}
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}

}
