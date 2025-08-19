import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int melon = Integer.parseInt(br.readLine()); // 참외 개수

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        map.put(3, new ArrayList<>());
        map.put(4, new ArrayList<>());

        int firstDir = 1;
        int secondDir = 1;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            map.get(dir).add(len);

            if (i == 0) {
                firstDir = dir;
            }
            if (i == 1) {
                secondDir = dir;
            }
            if (i > 2 && dir == firstDir) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(map.get(firstDir).get(1));
                tmp.add(map.get(firstDir).get(0));
                map.put(firstDir, tmp);
            }

            if (i > 3 && dir == secondDir) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(map.get(secondDir).get(1));
                tmp.add(map.get(secondDir).get(0));
                map.put(secondDir, tmp);
            }

        }

        // one1, one2 -> 잘리지 않은 두 면
        int one1, one2;
        if (map.get(1).size() == 1) {
            one1 = 1;
        } else {
            one1 = 2;
        }

        if (map.get(3).size() == 1) {
            one2 = 3;
        } else {
            one2 = 4;
        }


        int original = map.get(one1).get(0) * map.get(one2).get(0);

        int blank = 0;
        if (one1 == 1 && one2 == 3) {
            // 공백이 서북
            blank = map.get(4).get(1) * map.get(2).get(0);
        }
        if (one1 == 1 && one2 == 4) {
            // 공백이 서남
            blank = map.get(2).get(1) * map.get(3).get(0);
        }
        if (one1 == 2 && one2 == 3) {
            // 공백이 동북
            blank = map.get(1).get(1) * map.get(4).get(0);
        }
        if (one1 == 2 && one2 == 4) {
            // 공백이 동남
            blank = map.get(3).get(1) * map.get(1).get(0);
        }

        int ans = melon * (original - blank);
        bw.write(ans+"");


        bw.flush();
        br.close();
        bw.close();

    }

}
