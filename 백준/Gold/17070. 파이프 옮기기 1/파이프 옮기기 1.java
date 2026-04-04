import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] field = new int[n + 1][n + 1];
        int[][][] dp = new int[n + 1][n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 상태: (1, 2)에 가로(0)로 놓여 있음
        dp[1][2][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) { // (1, 2) 이후부터 계산
                if (field[i][j] == 1) continue;

                // 1. 가로로 도달하는 경우 (이전이 가로(0)거나 대각선(2))
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                // 2. 세로로 도달하는 경우 (이전이 세로(1)거나 대각선(2))
                if (i - 1 >= 1) {
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                }

                // 3. 대각선으로 도달하는 경우 (이전이 0, 1, 2 모두 가능)
                // 대각선은 위와 왼쪽 칸도 비어있어야 함
                if (i - 1 >= 1 && field[i - 1][j] == 0 && field[i][j - 1] == 0) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        // 모든 방향의 경우의 수를 합산
        long answer = (long)dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        System.out.println(answer);
    }
}