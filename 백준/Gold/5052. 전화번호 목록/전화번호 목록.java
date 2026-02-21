import javax.sql.rowset.BaseRowSet;
import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        Node[] children = new Node[10];
        boolean isEnd;
        int childCnt = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            String[] nums = new String[n];
            for (int i = 0; i < n; i++) nums[i] = br.readLine();

            boolean isOk = true;
            Node root = new Node();

            for (String number : nums) {

                // search
                Node node = root;
                for (char c : number.toCharArray()) {
                     int num = Integer.parseInt(c+"");

                    // 다른 번호가 현재 번호의 prefix인 경우
                    if (node.isEnd) {
                        isOk = false;
                        break;
                    }

                     // 없다면 추가
                     if (node.children[num] == null) {
                         node.children[num] = new Node();
                         node.childCnt++;
                     }

                     node = node.children[num];
                }

                // 현재 번호가 다른 번호의 prefix인 경우
                if (!node.isEnd && node.childCnt >= 1) {
                    isOk = false;
                    break;
                }

                node.isEnd = true;
            }

            System.out.println(isOk ? "YES" : "NO");
        }

        br.close();
    }
}