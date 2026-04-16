import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 트리 크기 설정
        tree = new int[N * 4];

        // 1. 트리 초기화
        init(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 2. 구간 최솟값 쿼리 수행
            sb.append(query(1, 1, N, a, b)).append("\n");
        }
        System.out.print(sb);
    }

    // 세그먼트 트리 초기화 함수
    static int init(int node, int start, int end) {
        // 리프 노드인 경우
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        // 왼쪽 자식과 오른쪽 자식 중 더 작은 값을 부모에 저장
        return tree[node] = Math.min(init(node * 2, start, mid), 
                                     init(node * 2 + 1, mid + 1, end));
    }

    // 구간 최솟값 탐색 함수
    static int query(int node, int start, int end, int left, int right) {
        // 범위를 완전히 벗어난 경우
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }

        // 범위에 완전히 포함된 경우
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return Math.min(query(node * 2, start, mid, left, right), 
                        query(node * 2 + 1, mid + 1, end, left, right));
    }
}