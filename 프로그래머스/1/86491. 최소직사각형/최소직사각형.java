import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int[] w = new int[sizes.length];
        int[] h = new int[sizes.length];
        
        int idx = 0;
        for (int[] pair : sizes) {
            w[idx] = Math.max(pair[0], pair[1]);
            h[idx++] = Math.min(pair[0], pair[1]);
        }
        
        Arrays.sort(w);
        Arrays.sort(h);
        
        return w[idx-1] * h[idx-1];
    }
}