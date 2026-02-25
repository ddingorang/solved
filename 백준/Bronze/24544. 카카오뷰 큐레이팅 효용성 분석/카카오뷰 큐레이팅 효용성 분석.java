import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] interests = new int[n];

        st = new StringTokenizer(br.readLine());
        int summ = 0;
        for(int i=0; i<n; i++) {
            interests[i] = Integer.parseInt(st.nextToken());
            summ += interests[i];
        }

        st = new StringTokenizer(br.readLine());
        int nr = 0;
        for(int i=0; i<n; i++) {
            int registered = Integer.parseInt(st.nextToken());
            if(registered == 0) {
                nr += interests[i];
            }
        }

        System.out.println(summ);
        System.out.println(nr);

    }
}
