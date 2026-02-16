import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            List<Integer>[] G = new List[v+1];
            for(int k=0; k<=v; k++) G[k]=new ArrayList<>();

            int[] income = new int[v+1];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<e; j++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                G[start].add(end);
                income[end]++;
            }

            ArrayDeque<Integer> q = new ArrayDeque<>(); // 큐 활용
            for(int j=1; j<=v; j++) { // 진입차수가 0인 노드 삽입
                if(income[j] == 0) q.offer(j);
            }

            sb.append("#").append(i+1).append(" ");
            while(!q.isEmpty()) {
                int u = q.poll(); // 큐에서 빼면
                sb.append(u).append(" ");
                for(int next : G[u]) { // 큐에서 뺀 노드의 인접 노드
                    income[next]--; // 인접 노드의 진입 차수를 하나씩 줄인다
                    if(income[next] == 0) { // 그 노드가 진입차수가 0이 되었으면
                        q.offer(next); // 큐에 넣기
                    }
                }

            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}