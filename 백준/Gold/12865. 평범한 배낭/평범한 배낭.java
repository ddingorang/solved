import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 무게 k까지 담았을 때의 최대 가치
        int[] dp = new int[k+1];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 무게
            int v = Integer.parseInt(st.nextToken()); // 가치

            for(int j = k; j>=w; j--) {
                dp[j] = Math.max(dp[j], dp[j-w]+v);
                // w == 6, v == 13일 때
                // dp[7] = Math.max(dp[7], dp[7-6] + 13); -> 13
                // dp[6] = Math.max(dp[6], dp[6-6] + 13); -> 13

                // w == 4, v == 8일 때
                // dp[7] = Math.max(dp[7], dp[7-4] + 8); -> 13
                // dp[6] = Math.max(dp[6], dp[6-4] + 8); -> 13
                // dp[5] = Math.max(dp[5], dp[5-4] + 8); -> 8
                // dp[4] = Math.max(dp[4], dp[4-4] + 8); -> 8

                 // w == 3, v == 6일 때
                // dp[7] = Math.max(dp[7], dp[7-3] + 6); -> 14
                // dp[6] = Math.max(dp[6], dp[6-3] + 6); -> 13
                // dp[5] = Math.max(dp[5], dp[5-3] + 6); -> 8
                // dp[4] = Math.max(dp[4], dp[4-3] + 6); -> 8
                // dp[3] = Math.max(dp[3], dp[3-3] + 6); -> 6

                // w == 5, v == 12
                // dp[7] = Math.max(dp[7], dp[7-5] + 12); -> 14
                // dp[6] = Math.max(dp[6], dp[6-5] + 12); -> 13
                // dp[5] = Math.max(dp[5], dp[5-5] + 12); -> 12
            }
        }

        System.out.println(dp[k]);
    }
}