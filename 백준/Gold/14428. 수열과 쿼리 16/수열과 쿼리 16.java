import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int val, idx;
        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    static Node[] tree;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        tree = new Node[4 * n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        build(1, 1, n);

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 1) { // 업데이트
                arr[a] = b;
                update(1, 1, n, a, b);
            } else { // 쿼리
                sb.append(query(1, 1, n, a, b).idx).append("\n");
            }
        }
        System.out.print(sb);
    }

    // 두 노드를 합치는 로직 (핵심)
    static Node merge(Node n1, Node n2) {
        if (n1.val < n2.val) return n1;
        if (n1.val > n2.val) return n2;
        return n1.idx < n2.idx ? n1 : n2; // 값이 같으면 인덱스 작은 것
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(arr[start], start);
            return;
        }
        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    static void update(int node, int start, int end, int idx, int val) {
        if (idx < start || end < idx) return;
        if (start == end) {
            tree[node] = new Node(val, idx);
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, val);
        update(node * 2 + 1, mid + 1, end, idx, val);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    static Node query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return merge(query(node * 2, start, mid, left, right), query(node * 2 + 1, mid + 1, end, left, right));
    }
}