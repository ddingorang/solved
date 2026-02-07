import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 메모리 절약을 위해 현재와 이전 행만 저장 (크기 3)
        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());

            if (i == 0) {
                maxDp[0] = minDp[0] = n1;
                maxDp[1] = minDp[1] = n2;
                maxDp[2] = minDp[2] = n3;
            } else {
                // 이전 값을 보관
                int prevMax0 = maxDp[0], prevMax1 = maxDp[1], prevMax2 = maxDp[2];
                int prevMin0 = minDp[0], prevMin1 = minDp[1], prevMin2 = minDp[2];

                // 최댓값 갱신
                maxDp[0] = Math.max(prevMax0, prevMax1) + n1;
                maxDp[1] = Math.max(Math.max(prevMax0, prevMax1), prevMax2) + n2;
                maxDp[2] = Math.max(prevMax1, prevMax2) + n3;

                // 최솟값 갱신
                minDp[0] = Math.min(prevMin0, prevMin1) + n1;
                minDp[1] = Math.min(Math.min(prevMin0, prevMin1), prevMin2) + n2;
                minDp[2] = Math.min(prevMin1, prevMin2) + n3;
            }
        }

        int maxResult = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]));
        int minResult = Math.min(minDp[0], Math.min(minDp[1], minDp[2]));

        System.out.println(maxResult + " " + minResult);
    }
}