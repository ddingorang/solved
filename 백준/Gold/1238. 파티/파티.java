import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken())-1;

        List<int[]>[] G = new List[N];
        List<int[]>[] R = new List[N];
        for(int i=0; i<N; i++)
        {
            G[i] = new ArrayList<>();
            R[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            G[from].add(new int[] {to, cost});
            R[to].add(new int[] {from, cost}); // 역방향 그래프
        }

        int[] go = dijkstra(N, X, G);
        // 파티장에서 각 학생의 집까지 최소 거리 = 파티장(X)에서 뻗어 나감
        int[] back = dijkstra(N, X, R);
        // 각 학생의 집에서 파티장까지 최소 거리 = 파티장(X)으로 전부 향함

        int maxx = -1;
        for(int i=0; i<N; i++) {
            // 집에서 파티장 + 파티장에서 집
            int summ = go[i] + back[i];
            if(summ > maxx) maxx = summ;
        }

        System.out.println(maxx);

    }

    private static int[] dijkstra(int N, int X, List<int[]>[] G) {
        int[] D = new int[N];
        Arrays.fill(D, Integer.MAX_VALUE);
        boolean[] v = new boolean[N];
        //int mst = 0, cnt = 0;
        D[X] = 0;
        for(int i = 0; i< N; i++) {
            if(i == X) continue;
            int min = Integer.MAX_VALUE;
            int minVertex = -1;
            for(int j = 0; j< N; j++){
                if(!v[j] && min > D[j]) {
                    min = D[j]; minVertex = j;
                }
            }

            if(minVertex == -1) break;
            v[minVertex] = true;
            //mst += min;
            for(int[] j : G[minVertex]) {
                if(!v[j[0]] && D[j[0]] > min + j[1]) {
                    D[j[0]] = min + j[1];
                }
            }
        }

        return D;
    }
}