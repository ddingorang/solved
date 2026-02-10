import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[] board;
    static int cnt;
    static void recur(int row){
        if(row == N) {
            cnt++;
            return;
        }

        for(int col=0; col<N; col++) {
            if(isSafe(row, col)) {
                board[row] = col;
                recur(row+1);

            }
        }
    }

    static boolean isSafe(int r, int c) {
        for(int rw=0; rw<r; rw++) {
            if(board[rw] == c) { // 열 체크
                return false;
            }

            if(board[rw] == c - (r-rw)) { // 대각선 체크
                return false;
            }
            else if(board[rw] == c + (r-rw)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<tc; i++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N];
            cnt = 0;

            recur(0);
            sb.append("#").append(i+1).append(" ").append(cnt).append("\n");

        }

        System.out.print(sb);
    }
}