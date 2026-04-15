import java.io.*;
import java.util.*;

public class Solution {

    static int N, R;
    static int[] a, b;
    static ArrayList<int[]> coords;
    static long xsum, ysum;
    static long minn;

    static void comb(int start, int cnt){
        if(cnt == R) {

            // 출발 그룹의 x좌표 총합, y좌표 총합
            long xStartSum = 0, yStartSum = 0;
            for(int e : b) {
                xStartSum += coords.get(e)[0];
                yStartSum += coords.get(e)[1];
            }

            // 도착 그룹의 x좌표, y좌표 총합은
            // 전체 지렁이의 x좌표, y좌표 총합에서 출발 그룹의 것을 빼면 됨
            long xEndSum = xsum - xStartSum;
            long yEndSum = ysum - yStartSum;

            // 총합 벡터의 x성분, y성분
            long xresult = xEndSum - xStartSum;
            long yresult = yEndSum - yStartSum;

            // 벡터의 크기 구하기
            long totalMovement = Math.abs(xresult * xresult + yresult * yresult);

            // 최소값 갱신
            if(totalMovement < minn) {
                minn = totalMovement;
            }

            return;
        }

        for(int i=start; i<N; i++) {
            b[cnt] = a[i];
            comb(i+1, cnt+1);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        // 핵심
        // 무조건 특정 두 점을 고르고(짝을 짓고 나서) 계산해야 된다 -> 아님(X)
        // 최종 합산 벡터의 합은 (end 그룹의 벡터 총합) - (start 그룹의 벡터 총합)

        // 1. 먼저 출발할 지렁이 그룹과 기다리고 있는(도착점) 지렁이 그룹을 나눈다. start / end 그룹 나누기
        // 2. 전체 지렁이의 x, y좌표 총합 구하기
        // 3. 절반 만큼 고른 지렁이들(start)의 x, y좌표 총합 구하기
        // 4. 전체에서 3에서 구한 것을 빼기 -> 자연스럽게 end 그룹의 x, y 좌표의 총합이 됨


        /*
        A, B, C, D중 출발을 (C, D), 도착을 (A, B)로 정했다 치자
        짝짓는 경우의 수는
        1. (A - C) + (B - D) = (A + B) - (C + D)
        2. (A - D) + (B - C) = (A + B) - (C + D)
        어떻게 짝을 지어 벡터를 만들든 결국 end 그룹의 벡터 총합 - start 그룹의 벡터 총합과 같음
         */

        for(int tc=0; tc<t; tc++) {
            N = Integer.parseInt(br.readLine());

            coords = new ArrayList<>();
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int xcoord = Integer.parseInt(st.nextToken());
                int ycoord = Integer.parseInt(st.nextToken());
                coords.add(new int[] {xcoord, ycoord});
            }

            // 먼저 모든 좌표들에 대해 x좌표의 합, y좌표의 합을 구해 놓는다.
            xsum = 0; ysum = 0;
            for(int[] e: coords) {
                xsum += e[0];
                ysum += e[1];
            }

            a = new int[N];
            R = N / 2; // 전체의 절반을 고름 - 조합
            b = new int[R];
            minn = Long.MAX_VALUE;
            for(int i=0; i<N; i++) {
                a[i] = i;
            }

            comb(0, 0);

            sb.append("#").append(tc+1).append(" ").append(minn).append("\n");
        }

        System.out.println(sb);
    }


}