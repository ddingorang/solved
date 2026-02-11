import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());

        for(int i=0; i<tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] tree = new int[n];
            st = new StringTokenizer(br.readLine());

            int max = -1;
            for(int j=0; j<n; j++) {
                tree[j] = Integer.parseInt(st.nextToken());
                if(tree[j] > max) {
                    max = tree[j];
                }
            }

            for(int k=0; k<n; k++) {
                tree[k] -= max;
            }

            int two = 0; // 짝수 날 물을 주는 횟수
            int one = 0; // 홀수 날 물을 주는 횟수
            // 일단 최대한 짝수 날 물을 많이 주려고 노력(2씩 자라기 때문에)
            for(int l=0; l<n; l++) {
                if(tree[l] % 2 == 0) two += (tree[l] / 2);
                else {
                    two += (tree[l]/2);
                    one += 1;
                }
            }
            
            // 하지만, 짝수/홀수 날 물을 주는 횟수 차이가 심하면
            // 그만큼 물을 줘야 하는 날이 늘어남
            // (홀수 날에는 물을 안주는 날이 많아짐)
            // 그렇기 때문에, 짝수날 한번 물 한번 주기 = 홀수날 물 2번 주는 것으로 바꿔
            // 최대한 두 날의 간극을 줄여야 함
            two = -two;
            while(two > one+1) {
                two--;
                one += 2;
            }

            int days=0;
            if(two > one) { // 짝수 날이 홀수 날보다 많은 경우
                // 홀수 날 하루는 물 안주고 쉼
                days = two*2;
            } else if (two == one) {
                days = one*2;
            }
            else { // 홀수 날이 짝수 날보다 많은 경우
                days = one*2-1;
            }

            sb.append("#").append(i+1).append(" ").append(days).append("\n");
        }

        System.out.println(sb);

    }


}