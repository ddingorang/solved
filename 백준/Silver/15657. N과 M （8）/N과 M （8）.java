import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, R, C;
    static int[] a, b = null;
    //static boolean[] v = null;
    static StringBuilder sb = new StringBuilder();

    static void comb(int cnt, int start) {
        if(cnt == R) {
            //System.out.println(Arrays.toString(b));

            for(int e : b) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
            C++; return;
        }
        for(int i=start; i<N; i++) {
            //if(v[i]) continue;
            //v[i] = true;

            b[cnt] = a[i];
            comb(cnt+1, i);

            //v[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        N = n;
        R = m;
        a = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        b = new int[R];
        //v = new boolean[N];
        C = 0;
        comb(0, 0);

        System.out.println(sb);
    }
}