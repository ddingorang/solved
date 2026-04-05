import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] g;
    static int del;
    static int count;

    static void dfs(int cur) {
        // 루트 자체가 삭제 노드인 경우를 메인에서 걸러주지만, 안전을 위해 추가
        if (cur == del) return;

        int childCount = 0;
        for (int next : g[cur]) {
            // 삭제된 노드라면 자식으로 치지 않고 방문도 하지 않음
            if (next == del) continue;

            childCount++;
            dfs(next);
        }

        // 자식이 하나도 없거나, 있었는데 삭제되었다면 리프 노드임
        if (childCount == 0) {
            count++;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        g = new ArrayList[n];
        count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;

        for(int i=0; i<n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) root = i;
            else {
                g[parent].add(i);
            }
        }

        del = Integer.parseInt(br.readLine());

        // 루트 노드가 삭제된 노드가 아닐 때만 탐색 시작
        if (root != del) {
            dfs(root);
            System.out.println(count);
        } else {
            // 루트가 삭제되면 리프 노드는 0개
            System.out.println(0);
        }
    }
}