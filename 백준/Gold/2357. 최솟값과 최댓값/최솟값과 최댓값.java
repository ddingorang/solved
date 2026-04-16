import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] minTree, maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 트리 크기 설정 (보통 4 * N)
        minTree = new int[N * 4];
        maxTree = new int[N * 4];

        init(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            int minVal = findMin(1, 1, N, left, right);
            int maxVal = findMax(1, 1, N, left, right);
            sb.append(minVal).append(" ").append(maxVal).append("\n");
        }
        System.out.print(sb);
    }

    // 트리 초기화
    static void init(int node, int start, int end) {
        if (start == end) {
            minTree[node] = maxTree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
    }

    // 최솟값 쿼리
    static int findMin(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return Integer.MAX_VALUE;
        if (left <= start && end <= right) return minTree[node];

        int mid = (start + end) / 2;
        return Math.min(findMin(node * 2, start, mid, left, right),
                        findMin(node * 2 + 1, mid + 1, end, left, right));
    }

    // 최댓값 쿼리
    static int findMax(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return Integer.MIN_VALUE;
        if (left <= start && end <= right) return maxTree[node];

        int mid = (start + end) / 2;
        return Math.max(findMax(node * 2, start, mid, left, right),
                        findMax(node * 2 + 1, mid + 1, end, left, right));
    }
}