import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] field = new char[m][];
        int[][] dist = new int[m][n];

        for(int i=0; i<m; i++) {
            String s = br.readLine();
            char[] row = s.toCharArray();
            field[i] = row;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // 0-1 bfs
        // 단순한 형태의 다익스트라
        // deque를 사용
        // 가중치가 0이면 앞, 1이면 뒤에 append하기

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        dist[0][0] = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            // 맨 오른쪽 아래에 도달
            if(cur[0] == m-1 && cur[1] == n-1) {
                System.out.println(dist[m-1][n-1]);
                break;
            }
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(0<=nx && nx < m && 0<=ny && ny < n) {
                    // dist는 지금까지 부시고 온 벽의 최소 개수 저장(지나온 거리가 아님)
                    // 빈 방이면, dist 늘리지 않고 이전 칸의 dist 그대로
                    if(field[nx][ny] == '0' && dist[nx][ny] > dist[cur[0]][cur[1]]) {
                        q.offerFirst(new int[]{nx, ny});
                        dist[nx][ny] = dist[cur[0]][cur[1]];
                    }
                    // 벽이고, 부신 벽의 개수가 최소라면 부수기(이전 칸의 dist + 1)
                    else if(field[nx][ny] == '1' && dist[nx][ny] > dist[cur[0]][cur[1]] + 1) {
                        q.offer(new int[]{nx, ny});
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }

    }
}