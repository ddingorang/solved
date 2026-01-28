import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[2][n];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // DP 테이블 정의: dp[행][열]
            int[][] dp = new int[2][n];

            // 1. 초기값 설정 (첫 번째 열)
            dp[0][0] = board[0][0];
            dp[1][0] = board[1][0];

            // 2. n이 1보다 큰 경우 두 번째 열부터 계산
            if (n > 1) {
                // 두 번째 열은 대각선 이전 값만 더할 수 있음
                dp[0][1] = dp[1][0] + board[0][1];
                dp[1][1] = dp[0][0] + board[1][1];

                // 세 번째 열부터는 점화식 적용
                for (int c = 2; c < n; c++) {
                    // 바로 왼쪽 대각선 vs 한 칸 건너뛴 대각선 중 최대값 선택
                    dp[0][c] = Math.max(dp[1][c - 1], dp[1][c - 2]) + board[0][c];
                    dp[1][c] = Math.max(dp[0][c - 1], dp[0][c - 2]) + board[1][c];
                }
            }

            // 마지막 열의 위, 아래 값 중 큰 것이 정답
            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }
        System.out.print(sb);
    }
}