import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
    }
}