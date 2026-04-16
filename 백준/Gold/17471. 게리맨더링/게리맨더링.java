import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] population;
    static List<Integer>[] adj;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        population = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 1. 비트마스킹을 이용해 구역을 두 그룹으로 나눔
        // 1 << N 은 전체 부분집합의 개수. 
        // i는 한 그룹에 속한 구역들의 비트 상태를 의미함.
        for (int i = 1; i < (1 << N) - 1; i++) {
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    groupA.add(j + 1);
                } else {
                    groupB.add(j + 1);
                }
            }

            // 2. 각 그룹이 각각 연결되어 있는지 확인
            if (isConnected(groupA) && isConnected(groupB)) {
                int sumA = getPopulationSum(groupA);
                int sumB = getPopulationSum(groupB);
                minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
            }
        }

        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }

    // 그룹 내 구역들이 모두 연결되어 있는지 BFS로 확인
    static boolean isConnected(List<Integer> group) {
        if (group.isEmpty()) return false;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        
        int start = group.get(0);
        queue.offer(start);
        visited[start] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : adj[cur]) {
                // 인접한 구역이 현재 그룹에 속해 있고, 아직 방문하지 않았다면
                if (group.contains(neighbor) && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    count++;
                }
            }
        }

        // 방문한 구역의 수가 그룹 전체 구역 수와 같으면 연결된 것
        return count == group.size();
    }

    static int getPopulationSum(List<Integer> group) {
        int sum = 0;
        for (int node : group) {
            sum += population[node];
        }
        return sum;
    }
}