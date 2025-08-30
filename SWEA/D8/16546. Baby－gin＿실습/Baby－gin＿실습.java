import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            char[] temp = br.readLine().toCharArray();

            // 정수 배열로 전환
            List<Integer> cards = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                cards.add(Integer.parseInt(temp[i]+""));
            }

            boolean isBabyGin = false;
            for (int i = 0; i < 4; i++) {
                for (int j = i+1; j < 5; j++) {
                    for (int k = j+1; k < 6; k++) {
                        if (isRun(cards.get(i), cards.get(j) , cards.get(k)) || isTriplet(cards.get(i), cards.get(j) , cards.get(k))) {
                            List<Integer> rest = new ArrayList<>(cards);
                            rest.remove(k);
                            rest.remove(j);
                            rest.remove(i);
                            if (isRun(rest.get(0), rest.get(1), rest.get(2)) ||isTriplet(rest.get(0), rest.get(1), rest.get(2))) {
                                isBabyGin = true;
                                break;
                            }
                        }
                    }
                    if (isBabyGin) break;
                }
                if (isBabyGin) break;
            }

            if (isBabyGin) bw.write("#" + t + " true\n");
            else bw.write("#" + t + " false\n");


        }

        bw.flush();
        br.close();
        bw.close();

    }

    public static boolean isTriplet(int a, int b, int c) {
        return a==b && b==c;
    }

    public static boolean isRun(int a, int b, int c) {
        List<Integer> tmp = new ArrayList<>(Arrays.asList(a, b, c));
        Collections.sort(tmp);
        return tmp.get(0)+1 == tmp.get(1) && tmp.get(1)+1 == tmp.get(2);
    }

}