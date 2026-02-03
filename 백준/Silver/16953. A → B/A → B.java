import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        ArrayDeque<long[]> dq = new ArrayDeque<>();
        // {현재 값, 연산 횟수}
        dq.add(new long[] {A, 1}); // 문제에서 시작할 때 1을 더한 값을 출력하라 함

        boolean found = false;
        while (!dq.isEmpty()) {
            long[] cur = dq.poll();
            long val = cur[0];
            long count = cur[1];

            if (val == B) {
                System.out.println(count);
                found = true;
                break;
            }

            // 1. 2를 곱한다
            if (val * 2 <= B) {
                dq.add(new long[] {val * 2, count + 1});
            }

            // 2. 1을 뒤에 붙인다
            long nextVal = val * 10 + 1;
            if (nextVal <= B) {
                dq.add(new long[] {nextVal, count + 1});
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }
}