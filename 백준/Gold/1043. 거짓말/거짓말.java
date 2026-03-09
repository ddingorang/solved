import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    // 자기가 속한 집합의 대표 노드 찾기
    static int find(int x) {
        if (x == parent[x]) { // 대표 노드 찾음 찾음
            return x;
        }
        else {
            parent[x] = find(parent[x]); // 해당 노드의 값을 인덱스로 넣기 - 재귀
            return parent[x];
        }
    }

    // 대표 노드끼리 합치기 - 같은 집합으로
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) { // 다른 집합이라면
            parent[y] = x; //
        }
    }

    // 같은 집합인지 확인
    static boolean sameParent(int x, int y) {
        if(find(x) == find(y)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthnum = Integer.parseInt(st.nextToken());
        int[] truths = new int[0];
        if(truthnum > 0) {
            truths = new int[truthnum];
        }
        for (int i = 0; i < truthnum; i++) {
            truths[i] = Integer.parseInt(st.nextToken());
        }

        int[][] fullparty = new int[m][];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int pplnum = Integer.parseInt(st.nextToken());
            int[] party =  new int[pplnum];
            for(int j=0; j<pplnum; j++) {
                party[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0; j<pplnum-1; j++) {
                union(party[j], party[j+1]);
            }
            fullparty[i] = party;
        }

        if(truthnum == 0) {
            System.out.println(m);
        }
        else {
            for(int i=0; i<m; i++) {
                boolean possible = true;
                for(int j=0; j<truthnum; j++) {
                    if(find(fullparty[i][0]) == find(truths[j])) {
                        possible = false;
                        break;
                    }
                }
                if(possible) {
                    answer += 1;
                }
            }

            System.out.println(answer);
        }

    }

}