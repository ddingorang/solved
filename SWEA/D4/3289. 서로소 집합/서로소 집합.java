import java.io.*;
import java.util.*;

public class Solution {

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
        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parent = new int[n+1];
            for(int i = 1; i <= n; i++){
                parent[i] = i;
            }
            sb.append("#").append(tc+1).append(" ");

            for(int i=0; i<m; i++) {
                st =  new StringTokenizer(br.readLine());
                int cmd =  Integer.parseInt(st.nextToken());
                if(cmd == 0) { // 집합 합치기
                    int one = Integer.parseInt(st.nextToken());
                    int two = Integer.parseInt(st.nextToken());
                    union(one, two);
                }
                else if(cmd == 1) {
                    int one = Integer.parseInt(st.nextToken());
                    int two = Integer.parseInt(st.nextToken());
                    if(sameParent(one, two)) {
                        sb.append(1);
                    }
                    else {
                        sb.append(0);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

}