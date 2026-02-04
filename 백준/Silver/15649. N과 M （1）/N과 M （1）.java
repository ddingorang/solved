import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, R, C;
    static int[] a, b = null;
    static boolean[] v = null; // 중복순열은 방문 처리 x
    static StringBuilder sb = new StringBuilder();

    static void perm(int cnt) {
        if(cnt == R) {
            //System.out.println(Arrays.toString(b));

            for(int e : b) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
            C++; return;
        }
        for(int i=0; i<N; i++) {
            if(v[i]) continue;
            v[i] = true;

            b[cnt] = a[i];
            perm(cnt+1);

            v[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        N = n;
        R = m;
        a = new int[N];
        for(int i=0; i<N; i++) {
            a[i] = i+1;
        }
        b = new int[R];
        v = new boolean[N];
        perm(0);

        System.out.println(sb);
    }
}