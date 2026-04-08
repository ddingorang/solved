import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 물건의 개수 (최대 100)
            int K = sc.nextInt(); // 배낭의 최대 부피 (최대 1000)

            int[] weights = new int[N + 1];
            int[] values = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                weights[i] = sc.nextInt();
                values[i] = sc.nextInt();
            }

            // 1. DP 배열 생성 (N+1 x K+1)
            int[][] dp = new int[N + 1][K + 1];

            // 2. DP 테이블 채우기
            for (int i = 1; i <= N; i++) {
                for (int w = 1; w <= K; w++) {
                    if (weights[i] <= w) {
                        // 현재 물건을 넣을 수 있는 경우:
                        // '안 넣었을 때(위쪽 칸)' vs '넣었을 때(가치 + 남은 무게의 최적값)'
                        dp[i][w] = Math.max(dp[i - 1][w], values[i] + dp[i - 1][w - weights[i]]);
                    } else {
                        // 현재 물건이 너무 무거운 경우: 이전 결과 그대로 가져옴
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }

            System.out.println("#" + tc + " " + dp[N][K]);
        }
        sc.close();
    }
}