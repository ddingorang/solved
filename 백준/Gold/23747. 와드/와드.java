import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0}; // U, D, L, R
    static int[] dy = {0, 0, -1, 1};
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // Added BufferedWriter
        StringTokenizer st = null;
        map.put("U", 0);
        map.put("D", 1);
        map.put("L", 2);
        map.put("R", 3);

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] field = new char[r][];
        char[][] v = new char[r][c];
        for(int i = 0; i < r; i++) {
            char[] row = br.readLine().toCharArray();
            field[i] = row;
        }
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++) {
                v[i][j] = '#';
            }
        }

        st = new StringTokenizer(br.readLine());
        // 시작 위치
        int curx = Integer.parseInt(st.nextToken()) -1;
        int cury = Integer.parseInt(st.nextToken()) -1;

        char[] cmds = br.readLine().toCharArray();
        for(int i=0; i<cmds.length; i++) {
            if(cmds[i] == 'W') { // 와드 설치 시
                char curArea = field[curx][cury];
                ArrayDeque<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{curx, cury});
                v[curx][cury] = '.';
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    for(int j=0; j<4; j++) {
                        int nx = cur[0] + dx[j];
                        int ny = cur[1] + dy[j];
                        if(0 <= nx && nx < r && 0 <= ny && ny < c) {
                            if(v[nx][ny] == '#' && field[nx][ny] == curArea) {
                                v[nx][ny] = '.';
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
            else { // 일반 이동
                int nx = curx + dx[map.get(String.valueOf(cmds[i]))];
                int ny = cury + dy[map.get(String.valueOf(cmds[i]))];
                curx = nx;
                cury = ny;
            }

            // 마지막 위치에서 상, 하, 좌, 우 시야 확보가 됨
            if(i == cmds.length-1) {
                v[curx][cury] = '.';
                for(int j=0; j<4; j++) {
                    if(0 <= curx+dx[j] && curx+dx[j] < r && 0 <= cury+dy[j] && cury+dy[j] < c) {
                        v[curx+dx[j]][cury+dy[j]] = '.';
                    }
                }
            }
        }

        for(int i=0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                bw.write(v[i][j]); // Changed to BufferedWriter
            }
            bw.newLine(); // Changed to BufferedWriter
        }
        bw.flush(); // Flush the buffer
        bw.close(); // Close the writer
    }
}
