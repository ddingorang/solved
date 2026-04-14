import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 10_000_001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n + 1][n + 1];
        int[][] route = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) dist[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (dist[a][b] > c) {
                dist[a][b] = c;
                route[a][b] = b;
            }
        }

        // 플로이드-워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        route[i][j] = route[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // 1. 거리 배열 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(dist[i][j] >= INF ? 0 : dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        // 2. 경로 역추적 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 갈 수 없거나 자기 자신인 경우 0 출력
                if (dist[i][j] == 0 || dist[i][j] >= INF) {
                    sb.append("0\n");
                    continue;
                }

                List<Integer> path = new ArrayList<>();
                int cur = i;
                while (cur != 0) {
                    path.add(cur);
                    if (cur == j) break;
                    cur = route[cur][j];
                }

                sb.append(path.size()).append(" ");
                for (int node : path) {
                    sb.append(node).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}