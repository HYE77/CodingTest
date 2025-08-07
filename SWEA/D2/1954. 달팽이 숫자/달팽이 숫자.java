import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			int[][] result = new int[N][N];		
			
			int currRow = 0;
			int currCol = 0;
			String currDir = "R";
			
			for (int i = 1; i < N*N+1; i++) {
				result[currRow][currCol] = i;
				
				switch (currDir) {
					case "R":
						if (currCol+1 < N && result[currRow][currCol+1] == 0) {
							currCol++;
							break;
						} else {
							currDir = "D";
							currRow++;
							break;
						}
					case "D":
						if (currRow+1 < N && result[currRow+1][currCol] == 0) {
							currRow++;
							break;
						} else {
							currDir = "L";
							currCol--;
							break;
						}
					case "L": 
						if (currCol-1 >= 0 && result[currRow][currCol-1] == 0) {
							currCol--;
							break;
						} else {
							currDir = "U";
							currRow--;
							break;
						}
						
					case "U" :
						if (currRow-1 >= 0 && result[currRow-1][currCol] == 0) {
							currRow--;
							break;
						} else {
							currDir = "R";
							currCol++;
							break;
					}
						
				}
				
			} 
			
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}
			
			
			
		}
		
		sc.close();
	}

}
