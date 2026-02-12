import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for(int t=0; t<tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Long m = Long.parseLong(st.nextToken());

            Long[] candies = new Long[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                candies[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(candies, Comparator.reverseOrder());

            // 한 개의 가방에 종류별로 몇 개씩 넣을 수 있을지를 고민 -> X
            // 몇 개의 가방을 만들 수 있을지를 고민 -> O
            // ex) 먼저 X개 가방을 만들어 보기로 하자
            // (종류별 사탕 개수) / (가방 개수)를 계산하여
            // 한 가방에 몇 개를 넣을 수 있는지 계산
            // 그 합이 m이 되도록 가방 개수(X)를 조절
            Long front = 1L;
            Long rear = candies[0];
            long ans = 0;

            // 가방 수를 절반씩 줄여가며 탐색
            while(front <= rear) {
                long mid = (front + rear) / 2;
                if(mid == 0) break; // 0으로 나누기 방지

                long pkgnum = 0;
                for(int i=0; i<candies.length; i++) {
                    pkgnum += (candies[i] / mid);
                }

                if(pkgnum >= m) {
                    // 가방 안에 m개의 사탕을 넣을 수 있음
                    // 혹시 m개 묶음 가방을 몇개 더 만들 수 있지 않을까..?
                    // 계속 해보기
                    ans = mid; // 일단 현재 묶음 개수를 저장
                    front = mid + 1;

                } else {
                    // 사탕이 m개보다 모자람
                    // 묶음 수를 줄여보자
                    rear = mid - 1;
                }
            }
            sb.append("#").append(t+1).append(" ").append(ans).append("\n");

        }
        System.out.println(sb);
    }
}