import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] board;
    static int cnt = 0;

    static void solve(int row){
        if(row == n) { // 끝까지 가면
            cnt++; // 추가
            return;
        }
        for(int col=0; col<n; col++) {
            if(isSafe(row, col)) {
                board[row] = col; // 퀸 놓기
                solve(row+1); // 다음 행
            }
        }
    }

    static boolean isSafe(int r, int c) {

        for(int i=0; i<r; i++) {
            // 1. 열 체크
            if(board[i] == c) { // 같은 열에 놓인 퀸이 있는가
                return false;
            }

            // 2. 대각선 체크
            if(board[i] == c-(r-i)) {
                return false;
            }
            else if(board[i] == c+(r-i)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n];
        solve(0);
        System.out.println(cnt);

    }
}