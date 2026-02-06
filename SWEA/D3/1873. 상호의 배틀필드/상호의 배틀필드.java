import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static char[] tankchars = {'^', 'v', '<', '>'};
    static String tankstrs = "^v<>";
    static String cmds = "UDLR";
    static int h, w;
    static char[][] field;

    static boolean isOnBoard(int x, int y) {
        if(0 <= x && x < h && 0 <= y && y < w) {
            return true;
        }
        else return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            field = new char[h][w];
            int[] tankpos = new int[2]; // 전차 위치
            int tankdir = -1; // 전차 방향

            for(int r = 0; r < h; r++) {
                String s = br.readLine();
                for(int c = 0; c<w; c++) {
                    field[r][c] = s.charAt(c);
                    // 초기 전차 위치와 방향 파악
                    if(tankstrs.contains(String.valueOf(s.charAt(c)))) {
                        tankpos[0] = r; tankpos[1] = c;
                        tankdir = tankstrs.indexOf(String.valueOf(s.charAt(c)));
                    }
                }
            }

            int cmdnum = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            for(int cmd = 0; cmd<cmdnum; cmd++) {
                char curcmd = commands.charAt(cmd);

                // 공격
                if(curcmd == 'S') {
                    int bombx = tankpos[0]; int bomby = tankpos[1];
                    while(true) {
                        bombx += dx[tankdir];
                        bomby += dy[tankdir];
                        if(isOnBoard(bombx, bomby)) {
                            if(field[bombx][bomby] == '*') { // 벽돌 벽을 만나면
                                field[bombx][bomby] = '.'; // 파괴됨
                                break;
                            }
                            else if(field[bombx][bomby] == '#') {
                                break;
                            }
                        }
                        else break;

                    }
                }
                // 이동
                else {
                    tankdir = cmds.indexOf(curcmd); // 방향 수정
                    field[tankpos[0]][tankpos[1]] = tankstrs.charAt(tankdir); // 방향 바꾸어놓기

                    int nx = tankpos[0] + dx[tankdir];
                    int ny = tankpos[1] + dy[tankdir];
                    if(isOnBoard(nx, ny)) {
                        if(field[nx][ny] == '.') { // 이동할 곳이 평지라면
                            field[tankpos[0]][tankpos[1]] = '.'; // 원상복구
                            tankpos[0] = nx; tankpos[1] = ny; // 탱크 이동
                            field[tankpos[0]][tankpos[1]] = tankstrs.charAt(tankdir); // 필드에 반영
                        }
                    }
                }

            }

            sb.append("#").append(i+1).append(" ");

            for(int row=0; row<h; row++) {
                for(int col = 0; col<w; col++) {
                    sb.append(field[row][col]);
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }
}