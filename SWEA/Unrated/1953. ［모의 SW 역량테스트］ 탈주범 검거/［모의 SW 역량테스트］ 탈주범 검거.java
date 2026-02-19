import java.io.*;
import java.util.*;

public class Solution {
    // 상: 0, 하: 1, 좌: 2, 우: 3
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] opp = {1, 0, 3, 2}; // 반대 방향 매핑 (상<->하, 좌<->우)

    // 파이프 종류별 이동 가능 여부 [파이프번호][상,하,좌,우]
    static boolean[][] pipe = {
        {false, false, false, false}, // 0번 (없음)
        {true, true, true, true},    // 1번 (상하좌우)
        {true, true, false, false},   // 2번 (상하)
        {false, false, true, true},   // 3번 (좌우)
        {true, false, false, true},   // 4번 (상우)
        {false, true, false, true},   // 5번 (하우)
        {false, true, true, false},   // 6번 (하좌)
        {true, false, true, false}    // 7번 (상좌)
    };

    static int N, M, R, C, L;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#" + t + " " + bfs());
        }
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{R, C, 1}); // {r, c, time}
        visited[R][C] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int time = curr[2];

            // 소요 시간 L에 도달하면 더 이상 이동하지 않음
            if (time >= L) continue;

            int currType = map[r][c];

            for (int d = 0; d < 4; d++) {
                // 1. 현재 파이프가 d 방향으로 갈 수 있는지 확인
                if (pipe[currType][d]) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // 2. 맵 범위 내에 있고, 파이프가 있으며, 아직 방문 안 한 경우
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] > 0 && !visited[nr][nc]) {
                        int nextType = map[nr][nc];
                        
                        // 3. 핵심: 다음 칸의 파이프가 나의 진행 방향과 연결되는지(반대 방향이 뚫려 있는지) 확인
                        if (pipe[nextType][opp[d]]) {
                            visited[nr][nc] = true;
                            count++;
                            q.offer(new int[]{nr, nc, time + 1});
                        }
                    }
                }
            }
        }
        return count;
    }
}