import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Long[] dp = new Long[1001];

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 3L;
        dp[3] = 5L;

        for(int i = 4; i < n+1; i++ ){
            dp[i] =(dp[i-1] + 2*dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);

    }
}