import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] field;
    static boolean[][] v;
    static int n;
    static int k;
    static List<Integer> r;

    static void dfs(int i, int j, int depth, boolean chance) {
        for(int d=0; d<4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if(0<=nx && nx<n && 0<= ny && ny < n) {
                if(field[nx][ny] < field[i][j] && !v[nx][ny]) {
                    v[nx][ny] = true;
                    dfs(nx, ny, depth + 1, chance);
                    v[nx][ny] = false;
                }
                // 깎으면 등산로를 찾을 수 있는 경우
                // 단 한번 가능, chance 변수로 체크
                else if(field[nx][ny] - k < field[i][j] && !v[nx][ny] && !chance) {
                    int temp = field[nx][ny];
                    field[nx][ny] = field[i][j] - 1; // 현재 위치보다 1만 작게 깎아야 유리
                    v[nx][ny] = true;
                    dfs(nx, ny, depth + 1, true); // 깎을 수 있는 chance 사용
                    field[nx][ny] = temp; // 다시 원상복구
                    v[nx][ny] = false;

                }
            }

        }
        // 더 이상 등산로를 개척할 수 없는 경우 여기로 오게 됨
        // 그 때의 깊이 append
        r.add(depth);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int tc = Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            field = new int[n][n];

            int maxValue = -1;
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    field[i][j] = Integer.parseInt(st.nextToken());
                    if(field[i][j] > maxValue) maxValue = field[i][j];
                }
            }

            r = new ArrayList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    // 가장 높은 봉우리 시작
                    if(field[i][j] == maxValue) {
                        v = new boolean[n][n];
                        v[i][j] = true;
                        dfs(i, j, 1, false);
                    }
                }
            }

            sb.append("#").append(t+1).append(" ").append(r.stream().max(Integer::compare).orElse(0)).append("\n");
        }

        System.out.println(sb);

    }
}
