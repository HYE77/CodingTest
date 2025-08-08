import java.util.ArrayList;
import java.util.List;

class Solution {
	static List<int[]> answer = new ArrayList<>();
    public int[][] solution(int n) {
        // List<int[]> answer = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        int N = answer.size();
        int[][] answer2 = new int[N][2];
        for (int i = 0; i < N; i++) {
            answer2[i] = answer.get(i);
        }
        return answer2;
    }
    
    public static void hanoi(int N, int from, int to, int tmp) {
        // base case (N=1)
        if (N==0) return;
        
        // recursive case
        hanoi(N-1, from, tmp, to);
        int[] arr = {from, to};
        answer.add(arr);
        //System.out.println(N + "번째 원반을 " + from + "에서 " + to + "(으)로 옮기기");
        
        hanoi(N-1, tmp, to, from);
    }
}