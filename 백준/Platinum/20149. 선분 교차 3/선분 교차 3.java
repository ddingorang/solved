import java.io.*;
import java.util.*;

public class Main {
    static long[] x = new long[4];
    static long[] y = new long[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        x[0] = Long.parseLong(st.nextToken());
        y[0] = Long.parseLong(st.nextToken());
        x[1] = Long.parseLong(st.nextToken());
        y[1] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x[2] = Long.parseLong(st.nextToken());
        y[2] = Long.parseLong(st.nextToken());
        x[3] = Long.parseLong(st.nextToken());
        y[3] = Long.parseLong(st.nextToken());

        int abc = ccw(x[0], y[0], x[1], y[1], x[2], y[2]);
        int abd = ccw(x[0], y[0], x[1], y[1], x[3], y[3]);
        int cda = ccw(x[2], y[2], x[3], y[3], x[0], y[0]);
        int cdb = ccw(x[2], y[2], x[3], y[3], x[1], y[1]);

        boolean intersect = false;
        if ((long)abc * abd <= 0 && (long)cda * cdb <= 0) {
            if (abc * abd == 0 && cda * cdb == 0) {
                // 네 점이 일직선상에 있는 경우의 범위 체크
                if (Math.min(x[0], x[1]) <= Math.max(x[2], x[3]) && Math.min(x[2], x[3]) <= Math.max(x[0], x[1]) &&
                    Math.min(y[0], y[1]) <= Math.max(y[2], y[3]) && Math.min(y[2], y[3]) <= Math.max(y[0], y[1])) {
                    intersect = true;
                }
            } else {
                intersect = true;
            }
        }

        if (intersect) {
            System.out.println(1);
            // 교점 출력 로직 호출
            printIntersection(abc, abd, cda, cdb);
        } else {
            System.out.println(0);
        }
    }

    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long val = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if (val > 0) return 1;
        if (val < 0) return -1;
        return 0;
    }

    private static void printIntersection(int abc, int abd, int cda, int cdb) {
        // 1. 네 점이 일직선상에 있을 때 (끝점이 닿는 경우만 좌표 출력)
        if (abc == 0 && abd == 0 && cda == 0 && cdb == 0) {
            // 끝점 4개 중 서로 겹치는 점이 있는지 모든 경우 확인
            if (x[0] == x[2] && y[0] == y[2] && Math.max(x[0], x[1]) <= Math.min(x[2], x[3]) && Math.max(y[0], y[1]) <= Math.min(y[2], y[3])) { } // 이미 정렬 로직이 복잡하므로 간단하게 아래 방식 추천
            
            // 더 직관적인 일직선 끝점 겹침 판정:
            // 선분1의 끝점이 선분2의 끝점과 같으면서, 나머지 끝점들은 서로 반대 방향에 있을 때
            if (x[1] == x[2] && y[1] == y[2] && Math.max(x[0], x[1]) <= Math.min(x[2], x[3]) && Math.max(y[0], y[1]) <= Math.min(y[2], y[3])) {
                // A-B(C)-D 순서일 때 (B=C)
                System.out.println(x[1] + " " + y[1]);
            } else {
                // 이 부분은 사실 정렬 후 비교가 가장 깔끔합니다.
                long[][] p = {{x[0], y[0]}, {x[1], y[1]}, {x[2], y[2]}, {x[3], y[3]}};
                // 선분1 정렬
                if (p[0][0] > p[1][0] || (p[0][0] == p[1][0] && p[0][1] > p[1][1])) {
                    long[] temp = p[0]; p[0] = p[1]; p[1] = temp;
                }
                // 선분2 정렬
                if (p[2][0] > p[3][0] || (p[2][0] == p[3][0] && p[2][1] > p[3][1])) {
                    long[] temp = p[2]; p[2] = p[3]; p[3] = temp;
                }

                // 한 점에서만 만나는 경우 (끝점이 닿음)
                if (p[1][0] == p[2][0] && p[1][1] == p[2][1]) System.out.println(p[1][0] + " " + p[1][1]);
                else if (p[3][0] == p[0][0] && p[3][1] == p[0][1]) System.out.println(p[3][0] + " " + p[3][1]);
            }
            return;
        }

        // 2. 기울기가 달라서 한 점에서 만나는 경우 (정밀도 유지)
        double det = (double)(x[0] - x[1]) * (y[2] - y[3]) - (double)(y[0] - y[1]) * (x[2] - x[3]);
        double px = ((double)(x[0] * y[1] - y[0] * x[1]) * (x[2] - x[3]) - (x[0] - x[1]) * (double)(x[2] * y[3] - y[2] * x[3])) / det;
        double py = ((double)(x[0] * y[1] - y[0] * x[1]) * (y[2] - y[3]) - (y[1] - y[0]) * (double)(x[2] * y[3] - y[2] * x[3])) / det; // 수정됨

        // py 계산 시 부호 주의: 공식에 따라 y1-y2 또는 y2-y1 확인
        py = ((double)(x[0] * y[1] - y[0] * x[1]) * (y[2] - y[3]) - (y[0] - y[1]) * (double)(x[2] * y[3] - y[2] * x[3])) / det;

        System.out.printf("%.15f %.15f\n", px, py);
    }
}