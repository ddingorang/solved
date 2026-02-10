import java.io.*;
import java.util.*;

public class Main {

    static int[] d = {-1, 0, 1};
    static int R;
    static int C;
    static boolean[][] v;
    static char[][] f;
    static int cnt;

    static boolean dfs(int row, int col) {
        v[row][col] = true;
        if(col == C-1) {
            cnt++;
            return true;
        }

        for(int dir=0; dir<3; dir++) {
            int nr = row + d[dir];
            int nc = col + 1;
            if(0 <= nr && nr < R && 0 <= nc && nc < C) {
                if(!v[nr][nc] && f[nr][nc] == '.') {
                    v[nr][nc] = true;
                    if(dfs(nr, nc)) return true; // 끝까지 갔으면 바로 return
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        f = new char[R][C];
        v = new boolean[R][C];
        cnt = 0;

        for(int i=0; i<R; i++) {
            char[] cc = br.readLine().toCharArray();
            f[i] = cc;
        }

        for(int rr = 0; rr<R; rr++) {
            dfs(rr, 0);

        }

        System.out.println(cnt);
    }
}