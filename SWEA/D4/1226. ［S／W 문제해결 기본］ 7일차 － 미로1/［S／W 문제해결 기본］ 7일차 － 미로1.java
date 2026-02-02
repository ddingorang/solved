import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int bfs(int i, int j, int[][] b, boolean[][] v) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[] {i, j});
        while(!q.isEmpty()) {
            int[] kl = q.poll();
            int k = kl[0];
            int l = kl[1];
            if(b[k][l] == 3) { // 도착점에 도달
                return 1;
            }
            for(int d = 0; d < 4; d++) {
                int dk = k + dx[d];
                int dl = l + dy[d];
                if(0 <= dk && dk < 16 && 0<= dl && dl < 16 && !v[dk][dl]) {
                    if(b[dk][dl] != 1) { // 벽이 아니면
                        v[dk][dl] = true;
                        q.offer(new int[] {dk, dl});
                    }

                }
            }
        }

        return 0; // 도착점에 도달 못함
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc < 11; tc++) {

            int x = Integer.parseInt(br.readLine());
            int[][] board = new int[16][16];
            boolean[][] v = new boolean[16][16];

            sb.append("#").append(tc).append(" ");
            for(int i=0; i<16; i++) {
                String temp = br.readLine();
                for(int j=0; j<16; j++) {
                    board[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
                }
            }

            for(int k=0; k<16; k++) {
                for(int l=0; l<16; l++) {
                    if(board[k][l] == 2) { // 시작점 발견
                        sb.append(bfs(k, l, board, v)).append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
