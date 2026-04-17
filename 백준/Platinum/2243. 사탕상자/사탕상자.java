import java.util.*;
import java.io.*;

public class Main {
    static int S = 1;
    static long[] tree;
    static final int MAX_TASTE = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. 트리 사이즈 결정 (100만보다 큰 2의 거듭제곱)
        while (S < MAX_TASTE) S <<= 1;
        tree = new long[S * 2];

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                // K번째 사탕 꺼내기
                long k = Long.parseLong(st.nextToken());
                int taste = query(1, k);
                sb.append(taste).append("\n");
                // 꺼낸 후 개수 -1 업데이트
                update(taste, -1);
            } else {
                // 사탕 넣기/빼기
                int taste = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                update(taste, count);
            }
        }
        System.out.print(sb);
    }

    // 트리를 타고 내려가며 K번째 사탕의 맛을 찾는 함수
    static int query(int node, long k) {
        // 리프 노드에 도달한 경우
        if (node >= S) {
            return node - S + 1;
        }

        // 왼쪽 자식에 사탕이 k개 이상 있다면 왼쪽으로 이동
        if (tree[node * 2] >= k) {
            return query(node * 2, k);
        } else {
            // 왼쪽 자식에 k개보다 적다면 오른쪽으로 이동 (k값 갱신)
            return query(node * 2 + 1, k - tree[node * 2]);
        }
    }

    // 특정 맛의 사탕 개수 업데이트
    static void update(int taste, int diff) {
        int idx = S + taste - 1;
        while (idx > 0) {
            tree[idx] += diff;
            idx /= 2;
        }
    }
}