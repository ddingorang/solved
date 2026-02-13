import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) max = trees[i]; // 최댓값 찾기
        }

        int front = 0;
        int rear = max;
        int best = 0;

        while (front <= rear) {
            int mid = (front + rear) / 2;

            // 핵심: tempsum은 반드시 long이어야 함!
            long tempsum = 0;
            for (int i = 0; i < n; i++) {
                if (trees[i] > mid) {
                    tempsum += (trees[i] - mid);
                }
            }

            if (tempsum >= m) { // 충분한 나무를 얻었다면
                best = mid;     // 일단 기록하고
                front = mid + 1; // 더 높이 잘라본다
            } else {            // 부족하다면
                rear = mid - 1; // 더 낮게 자른다
            }
        }
        System.out.println(best);
    }
}