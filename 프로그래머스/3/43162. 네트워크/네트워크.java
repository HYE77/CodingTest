import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        
        parent = new int[computers.length];
        for (int i = 0; i < computers.length; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < computers.length-1; i++) {
            for (int j = i+1; j < computers.length; j++) {
                if (computers[i][j] == 1) {
                    int pi = findParent(i);
                    int pj = findParent(j);
                    
                    if (pi != pj) parent[pi] = pj;
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int num : parent) set.add(findParent(num));
        
        return set.size();
        
    }
    
    static int findParent(int n) {
        if (parent[n] != n) parent[n] = findParent(parent[n]);
        return parent[n];
    }
}