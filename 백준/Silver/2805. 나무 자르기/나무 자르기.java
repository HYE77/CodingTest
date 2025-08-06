import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 나무 개수
		int M = Integer.parseInt(st.nextToken()); // 필요한 나무 길이
		
		int[] trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		// 가장 큰 나무 높이 구하기
		int maxHeight = 0;
		for (int tree : trees) {
			if (tree > maxHeight) {
				maxHeight = tree;
			}
		}

	
		
		int L = 0;
		int R = maxHeight;
//		int currMax = 0;
		
		while (L < R) {
			int mid = (L+R)/2;
			long cutSum = 0;
			for (int tree : trees) {
				cutSum += Math.max(0,  tree-mid);
			}
			
			if (cutSum >= M) {
//				currMax = mid;
				L = mid+1;
			} else {
				R = mid;
			}
			
			
		}
		
		System.out.println(R-1);
		
		
 	}

}
