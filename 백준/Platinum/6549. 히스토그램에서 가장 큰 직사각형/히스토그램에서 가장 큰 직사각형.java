import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] h;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if (n == 0) break; // 0이 입력되면 종료

            h = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                h[i] = Long.parseLong(st.nextToken());
            }

            // 트리 크기 설정 (4 * n)
            tree = new int[n * 4];
            init(1, 1, n);

            sb.append(getMaxArea(1, n)).append("\n");
        }
        System.out.print(sb);
    }

    // 최솟값의 '인덱스'를 저장하는 세그먼트 트리 초기화
    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = start;
            return;
        }
        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);

        if (h[tree[node * 2]] <= h[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }
    }

    // 구간 내 최솟값 인덱스 쿼리
    static int query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return -1;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        int m1 = query(node * 2, start, mid, left, right);
        int m2 = query(node * 2 + 1, mid + 1, end, left, right);

        if (m1 == -1) return m2;
        if (m2 == -1) return m1;
        return h[m1] <= h[m2] ? m1 : m2;
    }

    // 분할 정복으로 최대 넓이 계산
    static long getMaxArea(int left, int right) {
        int minIdx = query(1, 1, n, left, right);

        // 1. 현재 구간에서 가장 낮은 막대를 높이로 하는 직사각형 넓이
        long area = (long) (right - left + 1) * h[minIdx];

        // 2. 왼쪽 구간에서 나올 수 있는 최대 넓이
        if (left < minIdx) {
            area = Math.max(area, getMaxArea(left, minIdx - 1));
        }
        // 3. 오른쪽 구간에서 나올 수 있는 최대 넓이
        if (right > minIdx) {
            area = Math.max(area, getMaxArea(minIdx + 1, right));
        }

        return area;
    }
}