import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M;
    static boolean[] selected;
    static boolean[][] isForbidden; // 인접 행렬: 금지된 쌍 저장
    static int count;

    static void generateSubset(int cnt) {
        // 기저 조건: 모든 원소에 대해 포함 여부를 결정함
        if (cnt == N + 1) {
            // 금지된 쌍이 하나라도 있는지 검사
            if (isValid()) {
                count++;
            }
            return;
        }

        // 1. 현재 원소(cnt)를 포함하는 경우
        selected[cnt] = true;
        generateSubset(cnt + 1);

        // 2. 현재 원소(cnt)를 포함하지 않는 경우
        selected[cnt] = false;
        generateSubset(cnt + 1);
    }

    // 현재 선택된 조합이 유효한지(금지된 쌍이 없는지) 체크
    static boolean isValid() {
        for (int i = 1; i <= N; i++) {
            if (!selected[i]) continue;
            for (int j = i + 1; j <= N; j++) {
                if (selected[j] && isForbidden[i][j]) {
                    return false; // 금지된 쌍이 발견되면 무효
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            selected = new boolean[N + 1];
            isForbidden = new boolean[N + 1][N + 1];
            count = 0;

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                // 금지된 쌍을 2차원 boolean 배열로 관리!
                // 금지되었으면 1
                // (u, v) 금지 = (v, u) 금지
                isForbidden[u][v] = isForbidden[v][u] = true;
            }

            generateSubset(1);
            System.out.println("#" + t + " " + count);
        }
    }
}