import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static int[][] map, dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE; // 초기값 무한대
                }
            }

            System.out.println("#" + tc + " " + dijkstra());
        }
    }

    static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.offer(new int[]{0, 0, 0}); // {r, c, cost}
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];

            // 이미 처리된 더 짧은 경로가 있다면 스킵
            if (dist[r][c] < cost) continue;
            if (r == N - 1 && c == N - 1) return cost;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    // 다음 칸까지의 총 복구 비용 계산
                    if (dist[nr][nc] > dist[r][c] + map[nr][nc]) {
                        dist[nr][nc] = dist[r][c] + map[nr][nc];
                        pq.offer(new int[]{nr, nc, dist[nr][nc]});
                    }
                }
            }
        }
        return -1;
    }
}