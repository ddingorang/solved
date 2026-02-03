import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[102][102]; // 여유 있게
        int borderlen = 0; // 둘레 길이

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int x=a; x<a+10; x++) {
                for(int y=b; y<b+10; y++) {
                    board[x][y] = 1; // 색종이 붙이기 (10x10 크기로)
                }
            }
        }

        for(int k=1; k<=100; k++) {
            for(int l=1; l<=100; l++) {
                if(board[k][l] == 1) {
                    for(int d = 0; d<4; d++) {
                        int nx = k + dx[d];
                        int ny = l + dy[d];
                        if(0<=nx && nx<=100 && 0<=ny && ny<=100) {
                            if(board[nx][ny] == 0) {
                                borderlen++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(borderlen);
        
    }
}