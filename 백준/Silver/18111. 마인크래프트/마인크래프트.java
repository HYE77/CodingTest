import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int B = Integer.parseInt(st.nextToken()); // 초기 블록
		
		int[][] grid = new int[N][M];
		
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				int tmpCnt = map.getOrDefault(grid[i][j], 0);
				map.put(grid[i][j], ++tmpCnt);
			}
		}
		
		TreeSet<Integer> keyset = new TreeSet<>(map.keySet());
		int maxH = keyset.last();
		int minH = keyset.first();
		
		int minTime = Integer.MAX_VALUE;
		int maxHeight = Integer.MIN_VALUE;
		
		for (int h = maxH; h >= minH; h--) {
			int time = 0;
			int currB = B;
			int needs = 0;
			// 현재 높이 리밋보다 큰 애들 깎아내기 (블록 개수 더하기, 블록당 2초 더하기)
			// 현재 높이보다 낮은 애들에 블록 쌓기 (전체 개수가 블록보다 많으면 break / 블록 쌓기당 1초 더하기)
			
			// 1. 잘라내기
			for (int key : keyset) {
				if (key > h) {
					currB += (key - h) * map.get(key);
					time += 2 * (key - h) * map.get(key);
				} 
			}
			
			// 2. 쌓기
			for (int key : keyset) {
				if (key < h) {
					needs += (h - key) * map.get(key);
					time += (h - key) * map.get(key);
				}
			}
			
			if (needs > currB) continue;
			if (time < minTime) {
				minTime = time;
				maxHeight = h;
			}
			
		}
		
		bw.write(minTime + " " + maxHeight);
		
		
		bw.flush();
		br.close();
		bw.close();
	}

}
