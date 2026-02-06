import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] snacks = new int[n];
            int max = -1;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                snacks[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(snacks);

            // 투 포인터
            int f = 0;
            int r = snacks.length-1;

            while (f < r) {
                int sum = snacks[f] + snacks[r];

                if (sum <= m) {
                    // 1. 합이 M 이하인 경우: 최댓값 갱신 시도
                    // 현재 f에서 만들 수 있는 최선의 결과이므로,
                    // 더 큰 합을 찾아보기 위해 f를 오른쪽으로 한 칸 밀어봅니다.
                    if (sum > max) max = sum;
                    f++;
                } else {
                    // 2. 합이 M을 초과한 경우: 무게를 줄여야 함
                    // 가장 큰 값인 r을 줄여서 합을 낮춥니다.
                    r--;
                }
            }

            sb.append("#").append(i+1).append(" ").append(max).append("\n");

        }
        System.out.println(sb);
    }
}