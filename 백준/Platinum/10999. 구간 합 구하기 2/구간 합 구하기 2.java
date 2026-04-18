import java.io.*;
import java.util.*;

public class Main {
    static long[] tree, lazy, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        tree = new long[4 * n];
        lazy = new long[4 * n];

        for (int i = 1; i <= n; i++) arr[i] = Long.parseLong(br.readLine());

        build(1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (type == 1) { // 구간 갱신
                long val = Long.parseLong(st.nextToken());
                updateRange(1, 1, n, left, right, val);
            } else { // 구간 합
                sb.append(query(1, 1, n, left, right)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void push(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) { // 리프 노드가 아니면 자식에게 전파
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static void updateRange(int node, int start, int end, int left, int right, long diff) {
        push(node, start, end);
        if (right < start || end < left) return;
        if (left <= start && end <= right) {
            lazy[node] += diff;
            push(node, start, end);
            return;
        }
        int mid = (start + end) / 2;
        updateRange(node * 2, start, mid, left, right, diff);
        updateRange(node * 2 + 1, mid + 1, end, left, right, diff);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(int node, int start, int end, int left, int right) {
        push(node, start, end);
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
    }

    static void build(int node, int start, int end) {
        if (start == end) { tree[node] = arr[start]; return; }
        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}