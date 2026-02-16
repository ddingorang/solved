import java.util.*;

public class Solution {
    // 이미 계산한 숫자의 최대 턴수를 저장하는 메모이제이션 맵
    static Map<Integer, Integer> memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            memo = new HashMap<>();

            System.out.println("#" + tc + " " + solve(N));
        }
    }

    static int solve(int n) {
        // 1. 기저 조건: 한 자리 수이면 더 이상 쪼갤 수 없으므로 0턴
        if (n < 10) return 0;

        // 2. 메모 확인: 이미 계산된 결과가 있으면 반환
        if (memo.containsKey(n)) return memo.get(n);

        int maxTurn = 0;
        String s = String.valueOf(n);
        int len = s.length();
        int cutPositions = len - 1; // 자를 수 있는 틈의 개수

        // 3. 비트마스킹으로 자를 위치의 모든 조합 탐색
        // i는 1부터 (2^cutPositions - 1)까지: 최소 하나 이상의 틈을 선택
        for (int i = 1; i < (1 << cutPositions); i++) {
            int nextN = 1;
            int start = 0;

            // 각 틈(j)을 확인하며 자를지 말지 결정
            for (int j = 0; j < cutPositions; j++) {
                if ((i & (1 << j)) != 0) {
                    // j번째 틈을 자름 (start부터 j까지 슬라이싱)
                    nextN *= Integer.parseInt(s.substring(start, j + 1));
                    start = j + 1;
                }
            }
            // 마지막 남은 조각 처리
            nextN *= Integer.parseInt(s.substring(start));

            // 4. 재귀 호출을 통해 다음 단계의 최대 턴수를 구하고 현재 턴(+1) 합산
            maxTurn = Math.max(maxTurn, solve(nextN) + 1);
        }

        // 5. 결과 기록 후 반환
        memo.put(n, maxTurn);
        return maxTurn;
    }
}