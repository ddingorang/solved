import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

    static int[][] cheeze;
    static int[][] curr;
    static int N;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] v;
    static ArrayDeque<int[]> q = new ArrayDeque<>();

    static void bfs(int r, int c) {
        v[r][c] = true;
        q.offer(new int[] {r, c});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d = 0; d<4; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(0<=nx && nx < N && 0<= ny && ny < N) {
                    if(!v[nx][ny] && curr[nx][ny] == 0) {
                        q.offer(new int[] {nx, ny});
                        v[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            cheeze = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++) {
                    cheeze[i][j] = Integer.parseInt(st.nextToken());

                }
            }

            int maxcnt = 1;
            for(int s = 0; s<=100; s++) {
                curr = new int[N][N];
                int temp = 0;
                for(int r = 0; r<N; r++) {
                    for(int c = 0; c<N; c++) {
                        if(cheeze[r][c] <= s) { // 먹어버림
                            curr[r][c] = 1;
                        }else curr[r][c] = 0;
                    }
                }

                v = new boolean[N][N];
                for(int row = 0; row<N; row++) {
                    for(int col = 0; col<N; col++) {
                        if(curr[row][col] == 0 && !v[row][col]) {
                            bfs(row, col);
                            temp++;
                        }
                    }
                }
                maxcnt = Math.max(maxcnt, temp);

            }

            //System.out.println(maxcnt);
            sb.append("#").append(t).append(" ").append(maxcnt).append("\n");

        }

        System.out.println(sb);
    }
}