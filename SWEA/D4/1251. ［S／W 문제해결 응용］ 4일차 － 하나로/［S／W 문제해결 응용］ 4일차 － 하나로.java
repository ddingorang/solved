import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            long[] X = new long[N];
            long[] Y = new long[N];

            for (int i = 0; i < N; i++) X[i] = sc.nextLong();
            for (int i = 0; i < N; i++) Y[i] = sc.nextLong();

            double E = sc.nextDouble(); // 환경 부담 세율

            double[] P = new double[N];
            Arrays.fill(P, Double.MAX_VALUE);
            boolean[] v = new boolean[N];

            P[0] = 0;
            double totalL2 = 0;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                double min = Double.MAX_VALUE;
                int minVertex = -1;


                for (int j = 0; j < N; j++) {
                    if (!v[j] && min > P[j]) {
                        min = P[j];
                        minVertex = j;
                    }
                }

                if (minVertex == -1) break; // 연결 불가능한 경우 방지

                v[minVertex] = true;
                totalL2 += min;
                if (cnt++ == N) break;

                for (int next = 0; next < N; next++) {
                    if (!v[next]) {
                        long dx = X[minVertex] - X[next];
                        long dy = Y[minVertex] - Y[next];
                        double distSquare = (double)dx * dx + (double)dy * dy;

                        if (P[next] > distSquare) {
                            P[next] = distSquare;
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + Math.round(totalL2 * E));
        }
    }
}