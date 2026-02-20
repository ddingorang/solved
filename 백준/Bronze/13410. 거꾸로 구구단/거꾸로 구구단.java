import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] gugu = new int[k];
        for(int i=0; i<k; i++) {
            String cur = String.valueOf(n * (i+1));
            // 문자열 뒤집기 : StringBuilder의 reverse 활용
            String reversed = new StringBuilder(cur).reverse().toString();
            int after = Integer.parseInt(reversed);
            gugu[i] = after;
        }

        int maxValue = -1;
        for(int i=0; i<k; i++) {
            if(gugu[i] > maxValue) maxValue = gugu[i];
        }

        System.out.println(maxValue);
    }
}
