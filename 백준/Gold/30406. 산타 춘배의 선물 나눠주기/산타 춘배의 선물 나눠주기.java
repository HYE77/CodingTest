import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	int n = Integer.parseInt(st.nextToken());
        	
        	map.put(n, map.get(n) + 1);
        }
        
        int sum = 0;
        
        // 0-3 pair
        int cnt03 = Math.min(map.get(0), map.get(3));
        sum += 3 * cnt03;
        map.put(0, map.get(0)-cnt03);
        map.put(3, map.get(3)-cnt03);
        
        // 1-2 pair
        int cnt12 = Math.min(map.get(1), map.get(2));
        sum += 3 * cnt12;
        map.put(1, map.get(1)-cnt12);
        map.put(2, map.get(2)-cnt12);
        
        // 0-2 pair
        int cnt02 = Math.min(map.get(0), map.get(2));
        sum += 2 * cnt02;
        map.put(0, map.get(0)-cnt02);
        map.put(2, map.get(2)-cnt02);
        
        // 1-3 pair
        int cnt13 = Math.min(map.get(1), map.get(3));
        sum += 2 * cnt13;
        map.put(1, map.get(1)-cnt13);
        map.put(3, map.get(3)-cnt13);
        
        // 0-1 pair
        int cnt01 = Math.min(map.get(0), map.get(1));
        sum += 1 * cnt01;
        map.put(0, map.get(0)-cnt01);
        map.put(1, map.get(1)-cnt01);
        
        // 2-3 pair
        int cnt23 = Math.min(map.get(2), map.get(3));
        sum += 1 * cnt23;
        map.put(2, map.get(2)-cnt23);
        map.put(3, map.get(3)-cnt23);
        
        System.out.println(sum);
        
    }
}
