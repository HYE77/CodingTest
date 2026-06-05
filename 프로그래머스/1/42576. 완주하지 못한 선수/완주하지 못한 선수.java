import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        StringBuilder sb = new StringBuilder();
        
        Map<String, Integer> comp = new HashMap<>();
        
        for (String c : completion) {
            comp.put(c, comp.getOrDefault(c, 0)+1);
        }
        
        for (String p : participant) {
            if (comp.getOrDefault(p, 0) == 0) sb.append(p);
            else comp.put(p, comp.get(p)-1);
        }
        
        return sb.toString();
    }
}