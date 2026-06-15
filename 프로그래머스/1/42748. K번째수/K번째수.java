import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int size = commands.length;
        int[] ans = new int[size];
        
        int cnt = 0;
        for (int[] cmd : commands) {
            int from = cmd[0]-1;
            int to = cmd[1]-1;
            int idx = cmd[2]-1;
            
            int[] temp = new int[to-from+1];
            for (int k = 0; k < to-from+1; k++) {
                temp[k] = array[from+k];
            }
            
            Arrays.sort(temp);
            
            ans[cnt++] = temp[idx]; 
        }
        
        return ans;
        
    }
}