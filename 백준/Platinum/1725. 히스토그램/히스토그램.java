import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] h;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        h = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }

        tree = new int[N * 4];
        init(1, 1, N);

        System.out.println(getMaxArea(1, N));
    }

    // 구간 내에서 가장 높이가 낮은 '인덱스'를 저장하는 트리
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

    // 구간 내 최솟값의 '인덱스' 쿼리
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

    // 분할 정복을 통한 최대 넓이 계산
    static long getMaxArea(int left, int right) {
        int minIdx = query(1, 1, N, left, right);

        // 현재 구간에서 가장 낮은 막대를 이용한 넓이
        long area = (long)(right - left + 1) * h[minIdx];

        // 왼쪽 구간 탐색
        if (left < minIdx) {
            area = Math.max(area, getMaxArea(left, minIdx - 1));
        }
        // 오른쪽 구간 탐색
        if (right > minIdx) {
            area = Math.max(area, getMaxArea(minIdx + 1, right));
        }

        return area;
    }
}