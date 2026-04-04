import java.io.*;
import java.util.*;

public class Main {

    static boolean[] v;
    static int farthestNode;
    static int maxDistance;
    static ArrayList<int[]>[] G;

    static void dfs(int cur, int distance) {
        // 노드를 타고 들어가며 최대 거리와 노드가 갱신되고 있음
        if(distance > maxDistance) {
            maxDistance = distance;
            farthestNode = cur;
        }

        v[cur] = true;
        for(int[] adj : G[cur]) {
            if(!v[adj[0]]) {
                dfs(adj[0], distance + adj[1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        G = new ArrayList[n+1];
        v = new boolean[n+1];
        maxDistance = -1;

        for(int i=0; i<n+1; i++) {
            G[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                G[start].add(new int[]{to, weight});
            }
        }

        // 아무 노드에서 출발해서 가장 먼 노드 구하기
        dfs(1, 0);

        v = new boolean[n+1];
        maxDistance = -1;

        // 가장 먼 노드에서 다시 dfs를 돌려 거리의 최대값을 구함 -> 트리의 지름
        dfs(farthestNode, 0);
        System.out.println(maxDistance);

    }

}
