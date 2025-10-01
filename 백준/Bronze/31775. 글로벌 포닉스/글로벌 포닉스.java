import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] str = new String[3];
        
        for (int i = 0; i < 3; i++) {
        	str[i] = br.readLine();
        }
        
        Set<Character> set = new HashSet<>();
        Set<Character> pkl = new HashSet<>();
        pkl.add('p');
        pkl.add('k');
        pkl.add('l');
        
        
        for (String s : str) {
        	if (pkl.contains(s.charAt(0))) set.add(s.charAt(0));
        }
        
        String ans = set.size() == 3 ? "GLOBAL" : "PONIX";        
        
        bw.write(ans);
        bw.flush();
        br.close();
        bw.close();
    }
}
