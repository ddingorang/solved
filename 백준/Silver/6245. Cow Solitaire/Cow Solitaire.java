import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        int[][] dp = new int[n][n];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=1; i<10; i++) {
            if(i==1) map.put("A", 1);
            else {
                map.put(String.valueOf(i), i);
            }
        }
        map.put("T", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String card = st.nextToken();
                String number = String.valueOf(card.charAt(0));
                board[i][j] = map.get(number);
            }
        }

        dp[n-1][0] = board[n-1][0];
        for(int i=n-2; i>=0; i--) {
            dp[i][0] = dp[i+1][0] + board[i][0];
        }
        for(int i=1; i<n; i++) {
            dp[n-1][i] = dp[n-1][i-1] + board[n-1][i];
        }
        for(int i=n-2; i>=0; i--) {
            for(int j=1; j<n; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]) + board[i][j];
            }
        }
        System.out.println(dp[0][n-1]);
    }
}