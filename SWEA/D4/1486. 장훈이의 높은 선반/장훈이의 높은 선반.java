import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[] a;
    static boolean[] v;
    static int minheight;
    static int minimum;

    static void generateSubset(int cnt) {
        if(cnt == N) {
            int temp = 0;
            for(int i=0; i<N; i++) {
                if(v[i]) {
                    temp += a[i];
                }
            }
            if(temp >= minheight && temp < minimum) {
                minimum = temp;
            }
            return;
        }

        v[cnt] = true;
        generateSubset(cnt+1);

        v[cnt] = false;
        generateSubset(cnt+1);

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int tc = Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            minheight = Integer.parseInt(st.nextToken());

            a = new int[N];
            v = new boolean[N];
            minimum = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            generateSubset(0);
            sb.append("#").append(t+1).append(" ").append(minimum - minheight).append("\n");
        }

        System.out.println(sb);

    }
}