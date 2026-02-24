import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int totalpkm = 0;
        int max = -1;
        String whichismax = "";

        for(int i=0; i<n; i++) {
            String pkm = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;
            while(k <= m) {
                m -= k;
                m += 2;
                totalpkm += 1;
                count += 1;
            }
            if(count > max) {
                max = count;
                whichismax = pkm;
            }
        }

        System.out.println(totalpkm);
        System.out.println(whichismax);
    }
}