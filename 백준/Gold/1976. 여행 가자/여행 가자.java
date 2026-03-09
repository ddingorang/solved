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

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] cities = new int[n+1][n+1];

        parent =  new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                cities[i][j] = Integer.parseInt(st.nextToken());
                if(cities[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int[] plan = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
           plan[i] = find(Integer.parseInt(st.nextToken()));
        }

        boolean isConnected = true;
        int temp = plan[0];
        for(int i = 1; i < m; i++) {
            if(temp != plan[i]) {
                isConnected = false;
                break;
            }
            temp = plan[i];
        }

        if(isConnected) {
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }


    }

}