import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] v;
    static int N;
    static int[][] board;
    static ArrayList<int[]> coreList = new ArrayList<>();

    static int maxCores, minWire; // 정답 저장을 위한 전역 변수

    static void dfs(int idx, int cores, int lsum) {
        // 종료 조건: 모든 코어를 다 확인했을 때
        if (idx == coreList.size()) {
            if (cores > maxCores) {
                maxCores = cores;
                minWire = lsum;
            } else if (cores == maxCores) {
                minWire = Math.min(minWire, lsum);
            }
            return;
        }

        int[] cur = coreList.get(idx);
        int r = cur[0];
        int c = cur[1];

        // 4방향 시도
        for (int d = 0; d < 4; d++) {
            int count = 0;
            int nr = r, nc = c;

            // 1. 해당 방향으로 끝까지 갈 수 있는지 체크
            while (true) {
                nr += dx[d];
                nc += dy[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) break; // 경계 도달 (성공)
                if (board[nr][nc] != 0) { // 다른 코어나 전선을 만남 (실패)
                    count = -1;
                    break;
                }
                count++; // 전선 길이 카운트
            }

            // 2. 전선을 놓을 수 있다면 Marking 후 다음 코어로 이동
            if (count > 0) {
                // 전선 표시 (2)
                fill(r, c, d, count, 2); 
                // 다음 코어로
                dfs(idx + 1, cores + 1, lsum + count);
                // 복구 (Unmarking) - 백트래킹되면
                fill(r, c, d, count, 0); 
            }
        }

        // 3. 현재 코어를 연결하지 않고 넘어가는 경우 (중요!)
        dfs(idx + 1, cores, lsum);
    }

    // 전선을 놓거나 지우는 보조 메서드
    static void fill(int r, int c, int d, int cnt, int val) {
        for (int i = 0; i < cnt; i++) {
            r += dx[d];
            c += dy[d];
            board[r][c] = val;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            coreList = new ArrayList<>(); // 초기화
            maxCores = 0;
            minWire = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    // 가장자리가 아닌 코어만 탐색 리스트에 추가
                    if (board[i][j] == 1) {
                        if (i == 0 || i == N - 1 || j == 0 || j == N - 1) continue;
                        coreList.add(new int[]{i, j});
                    }
                }
            }

            dfs(0, 0, 0);
            sb.append("#").append(t).append(" ").append(minWire).append("\n");
        }

        System.out.println(sb);
    }
}