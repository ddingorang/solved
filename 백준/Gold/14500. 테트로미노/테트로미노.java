import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int maxResult = 0; // 최댓값만 저장

    // 상, 우, 하, 좌
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 좌표에서 탐색 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1. DFS로 4가지 모양 탐색
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false; // 백트래킹: 방문 해제

                // 2. DFS로 못 만드는 'ㅗ' 모양 별도 탐색
                checkExceptionShape(i, j);
            }
        }

        System.out.println(maxResult);
    }

    static void dfs(int i, int j, int depth, int sum) {
        // 기저 조건: 4칸을 모두 선택했을 때
        if (depth == 4) {
            maxResult = Math.max(maxResult, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            // 범위 체크 (nj < M 주의) 및 방문 여부 확인
            if (ni >= 0 && ni < N && nj >= 0 && nj < M && !visited[ni][nj]) {
                visited[ni][nj] = true;
                dfs(ni, nj, depth + 1, sum + map[ni][nj]);
                visited[ni][nj] = false; // 핵심: 다른 경로를 위해 다시 false로
                // 돌아왔을 때 다시 방문처리 취소
                // 방문처리 -> dfs -> 방문취소
            }
        }
    }

    // 'ㅗ' 모양(ㅏ, ㅓ, ㅗ, ㅜ) 처리 로직
    // + 모양(중심 + 상하좌우)에서 가장 작은 하나를 빼거나, 3개만 있으면 다 더함
    static void checkExceptionShape(int r, int c) {
        int sum = map[r][c];
        int wings = 0; // 중심 주변의 날개 개수
        int minVal = Integer.MAX_VALUE;

        for (int d = 0; d < 4; d++) {
            // 4방향 날개
            int nr = r + di[d];
            int nc = c + dj[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                wings++; // 날개 하나씩 더하고
                sum += map[nr][nc]; // 합산
                minVal = Math.min(minVal, map[nr][nc]); // 날개 중 가장 작은 값 저장
            }
        }

        // 날개가 4개면 (+ 모양) 가장 작은거 하나를 뺌 -> ㅗ, ㅏ, ㅓ, ㅜ 중 하나가 됨
        if (wings == 4) {
            maxResult = Math.max(maxResult, sum - minVal);
        }
        // 날개가 3개면 (T자 모양) 그대로 합산
        else if (wings == 3) {
            maxResult = Math.max(maxResult, sum);
        }

    }
}