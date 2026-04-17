import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] lastYear = new int[n];
            int[] inDegree = new int[n + 1];
            boolean[][] adj = new boolean[n + 1][n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                lastYear[i] = Integer.parseInt(st.nextToken());
            }

            // 1. 초기 간선 설정 (높은 순위 -> 낮은 순위)
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    adj[lastYear[i]][lastYear[j]] = true;
                    inDegree[lastYear[j]]++;
                }
            }

            // 2. 상대적 순위 변동 반영
            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if (adj[u][v]) {
                    adj[u][v] = false;
                    adj[v][u] = true;
                    inDegree[v]--;
                    inDegree[u]++;
                } else {
                    adj[v][u] = false;
                    adj[u][v] = true;
                    inDegree[u]--;
                    inDegree[v]++;
                }
            }

            // 3. 위상 정렬
            System.out.println(topologicalSort(n, adj, inDegree));
        }
    }

    private static String topologicalSort(int n, boolean[][] adj, int[] inDegree) {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        for (int i = 0; i < n; i++) {
            if (q.isEmpty()) return "IMPOSSIBLE"; // 사이클 발생
            if (q.size() > 1) return "?";         // 확실한 순위 보장 불가

            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int next = 1; next <= n; next++) {
                if (adj[cur][next]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) q.offer(next);
                }
            }
        }

        return sb.toString().trim();
    }
}