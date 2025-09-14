import java.util.*;
import java.io.*;

public class Main {

    static int L, C, ans;
    static char[] pwd;
    static char[] alpha;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 비번 길이
        C = Integer.parseInt(st.nextToken()); // 알파벳 개수

        pwd = new char[L];
        alpha = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);

        search(0);

        br.close();
    }

    static void search(int idx) {
        if (idx == L) {
            if (aeiou(pwd) && abc(pwd)) {
                System.out.println(pwd);
            }
            return;
        }

        for (int a = 0; a < C; a++) {
            if (idx == 0 || pwd[idx-1] < alpha[a]) {
                pwd[idx] = alpha[a];
                search(idx+1);
            }
        }
    }

    static boolean aeiou(char[] pwd) {
        boolean moreThanOne = false;
        for (char c : pwd) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                moreThanOne = true;
                break;
            }
        }

        return moreThanOne;
    }

    static boolean abc(char[] pwd) {
        boolean moreThanTwo = false;
        int cnt = 0;
        for (char c : pwd) {
            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                cnt++;
                if (cnt == 2) {
                    moreThanTwo = true;
                    break;
                }
            }
        }

        return moreThanTwo;
    }


}
