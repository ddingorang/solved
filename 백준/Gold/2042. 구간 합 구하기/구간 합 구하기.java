import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 1. 트리 크기 설정 (2N)
        tree = new long[2 * N];

        // 2. 리프 노드 채우기 (인덱스 N ~ 2N-1)
        for (int i = 0; i < N; i++) {
            tree[N + i] = Long.parseLong(br.readLine());
        }

        // 3. 트리 빌드 (Bottom-up)
        build();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                // b번째 수를 c로 바꾸기 (인덱스는 1부터 시작하므로 b-1)
                update(b - 1, c);
            } else {
                // b번째 수부터 c번째 수까지 합 구하기
                sb.append(query(b - 1, (int)c)).append("\n");
            }
        }
        System.out.print(sb);
    }

    // 트리 만들기(비재귀적)
    static void build() {
        for (int i = N - 1; i > 0; i--) {
            // 자식 둘의 합을 부모 값으로
            // 리프 노드(데이터)에서부터 시작
            tree[i] = tree[i << 1] + tree[i << 1 | 1];
        }
    }

    // 값 갱신
    static void update(int p, long value) {
        // 리프 노드 값 변경 후 부모로 올라가며 갱신
        for (tree[p += N] = value; p > 1; p >>= 1) {
            tree[p >> 1] = tree[p] + tree[p ^ 1];
        }
    }

    // 구간 합 구하기
    static long query(int l, int r) {
        long res = 0;
        // [l, r) 범위로 처리하기 위해 r에 +N을 한 뒤 r++ 느낌으로 접근
        for (l += N, r += N; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) == 1) res += tree[l++];
            if ((r & 1) == 1) res += tree[--r];
        }
        return res;
    }
}