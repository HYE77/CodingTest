import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        char[] original = br.readLine().toCharArray();
        String bomb = br.readLine();
        char[] part = bomb.toCharArray();
        
        char trigger = part[part.length-1]; // 폭발 문자열의 마지막 단어
        
        for (int i = 0; i < original.length; i++) {
        	sb.append(original[i]);
        	
        	if (original[i] == trigger) {
        		int start = sb.length() - part.length;
        		int end = sb.length();
        		
        		if (start < 0) continue;
        		
        		if (sb.substring(start, end).equals(bomb)) sb.delete(start, end);
        	}
        }
        
        if (sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb.toString());
        br.close();
    }
}
