import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken()); // 가로
        int height = Integer.parseInt(st.nextToken()); // 세로

        int N = Integer.parseInt(br.readLine());
        if (N ==0) {
            bw.write(width*height + "");
        } else {
            int[] hor = new int[N];
            int horsize = 0;
            int[] ver = new int[N];
            int versize = 0;

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                if (st.nextToken().equals("0")) {
                    hor[horsize++] = Integer.parseInt(st.nextToken());
                } else
                    ver[versize++] = Integer.parseInt(st.nextToken());
            }

            int[] hor2 = Arrays.copyOf(hor, horsize);
            Arrays.sort(hor2);
            int[] ver2 = Arrays.copyOf(ver, versize);
            Arrays.sort(ver2);

            int horMax = 0;
            for (int i = 0; i < horsize; i++) {
                if (i == 0) horMax = hor2[i];
                else horMax = Math.max(horMax, hor2[i] - hor2[i-1]);
            }
            if (horMax == 0) horMax = height;
            else horMax = Math.max(horMax, height - hor2[horsize-1]);

            int verMax = 0;
            for (int i = 0; i < versize; i++) {
                if (i == 0) verMax = ver2[i];
                else verMax = Math.max(verMax, ver2[i] - ver2[i-1]);
            }
            if (verMax == 0) verMax = width;
            else verMax = Math.max(verMax, width - ver2[versize-1]);


            bw.write(verMax*horMax + "");
        }



        bw.flush();
        bw.close();
        br.close();

    }
}
