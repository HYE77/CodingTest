
import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static Map<Integer, List<Integer>> info = new HashMap<>();
    static boolean[] parties;
    static boolean[] people;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 파티 수

        parties = new boolean[M]; // 진실을 말해야 하면 true
        people = new boolean[N+1]; // 진실을 알면 true

        Queue<Integer> q = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
        for (int i = 0; i < K; i++) {
            int person = Integer.parseInt(st.nextToken());
            q.add(person);
            people[person] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int peopleCnt = Integer.parseInt(st.nextToken());
            List<Integer> tmp = new ArrayList<>();
            for (int p = 0; p < peopleCnt; p++) {
                int person = Integer.parseInt(st.nextToken());
                tmp.add(person);
                if (people[person]) parties[i] = true;
            }
            info.put(i, tmp);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int par = 0; par < M; par++) {
                if (info.get(par).contains(curr)) {
                    parties[par] = true;
                    for (int per : info.get(par)) {
                        if (!people[per] && per > 0) {
                            q.add(per);
                            people[per] = true;
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (boolean tf : parties) {
            if (!tf) ans++;
        }

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
