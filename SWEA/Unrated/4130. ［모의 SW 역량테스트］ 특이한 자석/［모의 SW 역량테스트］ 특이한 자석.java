import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] magnets; // 자석들의 극성 정보
    static int[] rotatedir; // 각 자석이 회전할 방향 저장

    // 직접 회전시키기
    static void rotate(int[] magnet, int dir) {
        if (dir == 1) { // 시계 방향
            int tmp = magnet[7];
            for (int i = 7; i > 0; i--) magnet[i] = magnet[i - 1];
            magnet[0] = tmp;
        } else if (dir == -1) { // 반시계 방향
            int tmp = magnet[0];
            for (int i = 0; i < 7; i++) magnet[i] = magnet[i + 1];
            magnet[7] = tmp;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for(int i=0; i<tc; i++) {
            int k = Integer.parseInt(br.readLine());

            magnets = new int[5][];
            for(int mgnts = 0; mgnts < 5; mgnts++) {
                magnets[mgnts] = new int[8];
            }

            // 자석 극성 정보 입력받고
            for(int rows=1; rows<5; rows++) {
                st = new StringTokenizer(br.readLine());
                for(int cols = 0; cols < 8; cols++) {
                    magnets[rows][cols] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 각 명령 실행
            for(int tsk=0; tsk<k; tsk++) {
                st = new StringTokenizer(br.readLine());
                int whichmagnet = Integer.parseInt(st.nextToken());
                int whichway = Integer.parseInt(st.nextToken());
                rotatedir = new int[5];
                rotatedir[whichmagnet] = whichway;

                // 앞 자석으로 전파
                for(int mgn = whichmagnet; mgn>1; mgn--) { 
                    if(magnets[mgn][6] != magnets[mgn-1][2]) { // 마주한 부분 극성이 다른가 체크
                        rotatedir[mgn-1] = (-1)*rotatedir[mgn];
                    }
                    else break; // 전파 중단
                }

                // 뒤 자석으로 전파
                for(int mgn2 = whichmagnet; mgn2<4; mgn2++) { 
                    if(magnets[mgn2][2] != magnets[mgn2+1][6]) { // 마주한 부분 극성이 다른가 체크
                        rotatedir[mgn2+1] = (-1)*rotatedir[mgn2];
                    }
                    else break; // 전파 중단
                }

                // 회전 정보대로 회전시키기
                for(int ridx = 1; ridx < 5; ridx++) {
                    if(rotatedir[ridx] != 0) {
                        rotate(magnets[ridx], rotatedir[ridx]);
                    }
                }

            }
            
            // 점수 계산
            int scoresum = 0;
            for(int midx = 1; midx < 5; midx ++) {
                scoresum += magnets[midx][0] * (Math.pow(2, midx-1));
            }


            sb.append("#").append(i+1).append(" ").append(scoresum).append("\n");
        }

        System.out.println(sb);
    }
}