import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int r, c, cost;

    public Node(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }

    // 우선순위 큐에서 '비용이 적은 순'으로 정렬하기 위함
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int N;
    static int[][] board;
    static int[][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tc = 1;

        while (true) {
            N = sc.nextInt();
            if (N == 0) break; // 종료 조건

            board = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                    dist[i][j] = INF; // 최소 비용 배열을 무한대로 초기화
                }
            }

            int result = solve();
            System.out.println("Problem " + tc + ": " + result);
            tc++;
        }
    }

    public static int solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        // 1. 시작점 설정
        dist[0][0] = board[0][0];
        pq.offer(new Node(0, 0, board[0][0]));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // 2. 이미 더 짧은 경로를 찾았다면 건너뛰기 (중요: 성능 최적화)
            if (curr.cost > dist[curr.r][curr.c]) continue;

            // 3. 상하좌우 인접 칸 확인
            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    // 4. 현재 칸을 거쳐서 가는 게 더 저렴하다면 갱신
                    if (dist[nr][nc] > dist[curr.r][curr.c] + board[nr][nc]) {
                        dist[nr][nc] = dist[curr.r][curr.c] + board[nr][nc];
                        pq.offer(new Node(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }
        return dist[N - 1][N - 1];
    }
}