import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 트리 크기 설정 (4 * N)
        tree = new long[N * 4];
        
        long[] arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(arr, 1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // 업데이트
                update(1, 1, N, b, c);
            } else { // 구간 곱 쿼리
                sb.append(query(1, 1, N, b, (int)c)).append("\n");
            }
        }
        System.out.print(sb);
    }

    // 초기 트리 생성
    static long init(long[] arr, int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = (init(arr, node * 2, start, mid) * init(arr, node * 2 + 1, mid + 1, end)) % MOD;
    }

    // 값 변경 (재귀 방식)
    static long update(int node, int start, int end, int index, long val) {
        // 범위를 벗어난 경우 현재 노드 값 유지
        if (index < start || index > end) return tree[node];
        
        // 리프 노드에 도달한 경우 값 변경
        if (start == end) return tree[node] = val;

        int mid = (start + end) / 2;
        return tree[node] = (update(node * 2, start, mid, index, val) * update(node * 2 + 1, mid + 1, end, index, val)) % MOD;
    }

    // 구간 곱 계산
    static long query(int node, int start, int end, int left, int right) {
        // 범위를 완전히 벗어난 경우 (곱셈이므로 1 반환)
        if (left > end || right < start) return 1;
        
        // 범위에 완전히 포함된 경우
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return (query(node * 2, start, mid, left, right) * query(node * 2 + 1, mid + 1, end, left, right)) % MOD;
    }
}