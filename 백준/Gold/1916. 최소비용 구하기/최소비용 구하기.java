import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight; // 가중치 기준 오름차순 (최소 힙)
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] adj; // 인접 리스트
    static int[] dist;       // 최단 거리 저장 배열

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.end;
            int weight = cur.weight;

            // 현재 꺼낸 비용이 이미 기록된 최소 비용보다 크면 무시
            if (dist[now] < weight) continue;

            for (Node next : adj[now]) {
                // 현재 노드를 거쳐서 가는 비용 계산
                if (dist[next.end] > dist[now] + next.weight) {
                    dist[next.end] = dist[now] + next.weight;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
        return dist[end];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1]; // 도시 개수 + 1만큼 만들기
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>(); // 한 도시에 여러 도시로 향하는 길
        }

        // 최단거리 저장 배열 초기화
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        for(int x=0; x<m; x++) {

            // 인접 리스트 채우기
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[start].add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken()); // 출발
        int endCity = Integer.parseInt(st.nextToken()); // 도착

        System.out.println(dijkstra(startCity, endCity));
    }
}