import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int count = countIceberg();
            
            if (count >= 2) {
                System.out.println(year);
                break;
            } else if (count == 0) {
                System.out.println(0);
                break;
            }

            meltIceberg();
            year++;
        }
    }

    // 1. 빙산 덩어리 개수 확인 (BFS)
    static int countIceberg() {
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    static void bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] > 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    // 2. 빙산 녹이기
    static void meltIceberg() {
        int[][] melt = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int seaCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                            seaCount++;
                        }
                    }
                    melt[i][j] = seaCount;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = Math.max(0, map[i][j] - melt[i][j]);
            }
        }
    }
}