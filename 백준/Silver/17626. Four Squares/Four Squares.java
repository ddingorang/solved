import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[50001];
        int n = Integer.parseInt(br.readLine());

        int[] square = new int[224];
        for(int i=1; i<=223; i++) {
            square[i] = i*i;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;
        dp[5] = 2;

        // 점화식
        // dp[n] = min(dp[n-j*j]) + 1
        for(int i=6; i<=n; i++) {
            int min = Integer.MAX_VALUE;
            int j=1;
            while ((i - j * j) >= 0) {
                if (min > dp[i - j * j]) {
                    min = dp[i - j * j];
                }
                j++;
            }
            dp[i] = min + 1;

        }

        System.out.println(dp[n]);
    }
}