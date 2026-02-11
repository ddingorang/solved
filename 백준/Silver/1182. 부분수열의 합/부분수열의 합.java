import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int S;
    static int count;
    static int[] num;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];
        count = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (S == 0) count--;
        System.out.println(count);
    }

    static void dfs(int cnt, int sum) {
        if(cnt == N) {
            if(sum == S){
                count++;
            }
            return;
        }

        dfs(cnt+1, sum+ num[cnt]); // 선택하거나
        dfs(cnt+1, sum); // 말거나
    }
}