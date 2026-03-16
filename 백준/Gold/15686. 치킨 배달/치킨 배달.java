import java.util.*;
import java.io.*;

class Point {
    int r, c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int N, M, ans;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static Point[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) houses.add(new Point(i, j));
                else if (val == 2) chickens.add(new Point(i, j));
            }
        }

        selected = new Point[M];
        comb(0, 0);
        System.out.println(ans);
    }

    // 치킨집 M개를 뽑는 조합 (Backtracking)
    static void comb(int cnt, int start) {
        if (cnt == M) {
            ans = Math.min(ans, calculateCityDistance());
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[cnt] = chickens.get(i);
            comb(cnt + 1, i + 1);
        }
    }

    // 선택된 치킨집들과 집들 사이의 최소 거리 합 계산
    static int calculateCityDistance() {
        int sum = 0;
        for (Point h : houses) {
            int minDis = Integer.MAX_VALUE;
            for (Point c : selected) {
                int dist = Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
                minDis = Math.min(minDis, dist);
            }
            sum += minDis;
        }
        return sum;
    }
}