import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n이 0인 경우 처리
        if (n == 0) {
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = -1; // 문제의 범위에 따라 적절히 설정 (예: 0 또는 음수)
        int streak = 0;
        int maxStreak = 0;

        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if (cur > max) {
                // 새로운 최댓값 발견
                max = cur;
                streak = 0; // 최댓값이 바뀌었으므로 구간 초기화
            } else {
                // 최댓값보다 작거나 같은 경우 (갱신되지 않는 구간)
                streak++;
            }
            // 매번 최대 구간 길이 갱신
            maxStreak = Math.max(maxStreak, streak);
        }

        System.out.println(maxStreak);
    }
}