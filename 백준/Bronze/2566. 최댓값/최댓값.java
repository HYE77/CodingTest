import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int max = 0;
		int imax = 0;
		int jmax = 0;
		int[][] arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > max) {
					max = arr[i][j];
					imax = i;
					jmax = j;
				}
			}
		}
		imax++;
		jmax++;
		
		System.out.println(max);
		System.out.println(imax + " " + jmax);
		br.close();
	}

}