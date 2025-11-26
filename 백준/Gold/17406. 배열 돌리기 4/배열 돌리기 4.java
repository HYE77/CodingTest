import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K;  // 배열 행, 열, 연산 개수
	static int ans = Integer.MAX_VALUE;
	static int[][] grid, temp;
	static List<int[]> cmd = new ArrayList<>();
	static int[] selected;
	static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        grid = new int[N][M];
        selected = new int[K];
        visited = new boolean[K];
        
        // 초기 배열 만들기
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
        		grid[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // 연산 정보 입력 받기
        for (int i = 0; i < K; i++) {
        	st = new StringTokenizer(br.readLine());
        	cmd.add(new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())});
        }
        
        // 순열 만들기 -> 회전 연산 -> 최솟값 계산
        perm(0);
       
        System.out.println(ans);
        br.close();
    }
    
    
    static void perm(int sIdx) {
    	// 연산 순서 조합을 만드는 메서드
    	if (sIdx == K) {
    		// temp 배열 초기화 (원본 grid 복사)
    		temp = new int[N][M];
    		for (int i = 0; i < N; i++) {
    			temp[i] = Arrays.copyOf(grid[i], M);
    		}
    		
    		// 다 정했다면 순서에 따라 연산 후 결과 계산
    		for (int n : selected) {
    			int[] now = cmd.get(n);
    			shift(now[0], now[1], now[2]);
    		}
    		
    		ans = Math.min(ans, calc());
    		return;
    	}
    	
    	for (int i = 0; i < K; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			selected[sIdx] = i;
    			perm(sIdx+1);
    			visited[i] = false;
    		}
    	}
    }
    
    
    static void shift(int row, int col, int stage) {
    	// 시계 방향으로 배열을 돌리는 코드
    	for (int s = stage; s >= 1; s--) {
    		int top = row - s;
            int bottom = row + s;
            int left = col - s;
            int right = col + s;
            
    		// 상
    		int rightUp = temp[top][right];
    		for (int c = col+s; c > col-s; c--) {
    			temp[top][c] = temp[top][c-1];
    		}
    		
    		// 우
    		int rightDown = temp[bottom][right];
    		for (int r = bottom; r > top; r--) {
    			temp[r][right] = temp[r-1][right];
    		}
    		temp[top+1][right] = rightUp;
    		    		
    		// 하
    		int leftDown = temp[bottom][left];
    		for (int c = left; c < right; c++) {
    			temp[bottom][c] = temp[bottom][c+1];
    		}
    		temp[bottom][right-1] = rightDown; 
    		
    		// 좌
    		for (int r = top; r < bottom; r++) {
    			temp[r][left] = temp[r+1][left];
    		}
    		temp[bottom-1][left] = leftDown;
    	}
    }
    
    
    static int calc() {
    	int ans = Integer.MAX_VALUE;
    	for (int[] row : temp) {
    		int sum = 0;
    		for (int n : row) {
    			sum += n;
    		}
    		ans = Math.min(ans, sum);
    	}
    	
    	return ans;
    }
}