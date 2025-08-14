import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = 5;
		int[] arr = new int[N];
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		int average = sum / N;
		int median;
		
		if (N%2 == 1) 
			median = arr[N/2];
		else 
			median = (arr[N/2-1] + arr[N/2]) / 2;

		bw.write(average + "\n" + median);
		
		bw.flush();
		bw.close();
		br.close();
	}

}