import java.io.*;
import java.util.*;

public class Solution {

    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int[][] rooms;
    static int maxLen;
    static int startRoom;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int tc = Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++) {
            N = Integer.parseInt(br.readLine());
            rooms = new int[N][N];
            maxLen = -1;
            startRoom = -1;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++) {
                    boolean canBeStart = true;
                    for(int d = 0; d<4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(0<=nx && nx < N && 0 <= ny && ny < N) {
                            if(rooms[i][j]-rooms[nx][ny] == 1) {
                                canBeStart = false;
                                break;
                            }
                        }
                    }

                    // 진짜 시작점일 때만 탐색 시작
                    if (canBeStart) {
                        int len = 1;
                        int currR = i, currC = j;

                        // 나보다 1 큰 방이 있는 동안 쭉 직진 (반복문으로 처리 가능)
                        while (true) {
                            boolean moved = false;
                            for (int d = 0; d < 4; d++) {
                                int nx = currR + dx[d];
                                int ny = currC + dy[d];

                                if (nx >= 0 && nx < N && ny >= 0 && ny < N && rooms[nx][ny] == rooms[currR][currC] + 1) {
                                    currR = nx;
                                    currC = ny;
                                    len++;
                                    moved = true;
                                    break;
                                }
                            }
                            if (!moved) break;
                        }

                        // 결과 갱신
                        if (len > maxLen) {
                            maxLen = len;
                            startRoom = rooms[i][j];
                        } else if (len == maxLen) {
                            startRoom = Math.min(startRoom, rooms[i][j]);
                        }
                    }
                }
            }
            sb.append("#").append(t+1).append(" ").append(startRoom).append(" ").append(maxLen).append("\n");

        }
        System.out.println(sb);
    }
}