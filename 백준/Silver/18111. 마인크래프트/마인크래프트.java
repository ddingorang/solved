import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] ground = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHeight = -1;
        for(int h = 0; h<=256; h++) {
            int overheight = 0;
            int underheight = 0;
            int tempb = b;
            int time = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(ground[i][j]<h) underheight += (h-ground[i][j]);
                    else if(ground[i][j]>h) overheight += (ground[i][j]-h);
                }
            }
            // 1. 제거
            tempb += overheight; // 인벤토리 증가
            time += overheight * 2; // 2초 소요

            // 2. 배치
            if(tempb < underheight) continue; // 블럭이 부족하면 패스
            //tempb -= underheight; // 인벤토리의 블럭을 사용하여 배치
            time += underheight; // 1초 소요

            if(minTime >= time) {
                if(minTime == time) {
                    if(h > maxHeight) maxHeight = h;
                }
                else {
                    minTime = time;
                    maxHeight = h;
                }
            }


        }

        sb.append(minTime).append(" ").append(maxHeight);
        System.out.println(sb);
    }
}