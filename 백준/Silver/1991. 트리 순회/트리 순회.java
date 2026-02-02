import java.util.*;
import java.io.*;

class Node {
    char data;
    Node left, right; // 왼쪽, 오른쪽
    Node(char data) { this.data = data; }
}

public class Main {
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n];

        // 1. 노드 초기화 ('A'부터 순서대로 생성)
        for (int i = 0; i < n; i++) {
            tree[i] = new Node((char) ('A' + i));
        }

        // 2. 간선 연결
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left != '.') {
                tree[parent - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        // 3. 순회 결과 출력
        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
    }

    static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data);      // Root
        preOrder(node.left);              // Left
        preOrder(node.right);             // Right
    }

    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);               // Left
        System.out.print(node.data);      // Root
        inOrder(node.right);              // Right
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);             // Left
        postOrder(node.right);            // Right
        System.out.print(node.data);      // Root
    }
}