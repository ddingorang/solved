import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(bfs(A, B)).append("\n");
        }
        System.out.print(sb);
    }

    private static String bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        String[] result = new String[10000]; // 경로 저장용

        q.add(start);
        visited[start] = true;
        Arrays.fill(result, "");

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == target) return result[cur];

            // 4개 연산 적용
            int D = (cur * 2) % 10000;
            if (!visited[D]) {
                visited[D] = true;
                result[D] = result[cur] + "D";
                q.add(D);
            }

            int S = cur == 0 ? 9999 : cur - 1;
            if (!visited[S]) {
                visited[S] = true;
                result[S] = result[cur] + "S";
                q.add(S);
            }

            int L = (cur % 1000) * 10 + (cur / 1000);
            if (!visited[L]) {
                visited[L] = true;
                result[L] = result[cur] + "L";
                q.add(L);
            }

            int R = (cur % 10) * 1000 + (cur / 10);
            if (!visited[R]) {
                visited[R] = true;
                result[R] = result[cur] + "R";
                q.add(R);
            }
        }
        return "";
    }
}