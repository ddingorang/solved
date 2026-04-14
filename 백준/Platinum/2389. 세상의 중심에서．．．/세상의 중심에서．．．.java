import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        double distSq(Point p) {
            return (this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y);
        }
    }

    static class Circle {
        Point center; // x, y 좌표를 가진 Point 객체
        double radius; // 반지름 길이

        public Circle(Point center, double radius) {
            this.center = center;
            this.radius = radius;
        }

        // 웰즐 알고리즘의 2번 단계에서 사용되는 핵심 메서드
        public boolean contains(Point p) {
            // (중심과 점 p 사이의 거리) <= 반지름 이면 true
            // 정밀도를 위해 거리의 제곱으로 비교하는 것이 좋습니다.
            double d2 = center.distSq(p);
            return d2 <= (radius * radius) + 1e-9;
        }
    }

    public static Circle getMinCircleWithBoundary(List<Point> R) {
        if (R.isEmpty()) {
            return new Circle(new Point(0, 0), 0);
        } else if (R.size() == 1) {
            return new Circle(R.get(0), 0);
        } else if (R.size() == 2) {
            return getCircleTwoPoints(R.get(0), R.get(1));
        } else {
            // R.size() == 3
            return getCircumcircle(R.get(0), R.get(1), R.get(2));
        }
    }

    public static Circle getCircleTwoPoints(Point a, Point b) {
        Point center = new Point((a.x + b.x) / 2.0, (a.y + b.y) / 2.0);
        // 두 점 사이의 거리의 절반이 반지름입니다.
        double radius = Math.sqrt(a.distSq(b)) / 2.0;
        return new Circle(center, radius);
    }

    public static Circle getCircumcircle(Point a, Point b, Point c) {
        double x1 = a.x, y1 = a.y;
        double x2 = b.x, y2 = b.y;
        double x3 = c.x, y3 = c.y;

        double D = 2 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));

        // 세 점이 일직선상에 있는 경우 (D == 0)
        if (Math.abs(D) < 1e-9) {
            // 이 경우 세 점 중 가장 먼 두 점으로 원을 만듭니다.
            double d12 = a.distSq(b), d23 = b.distSq(c), d31 = c.distSq(a);
            if (d12 >= d23 && d12 >= d31) return getCircleTwoPoints(a, b);
            if (d23 >= d12 && d23 >= d31) return getCircleTwoPoints(b, c);
            return getCircleTwoPoints(c, a);
        }

        double ux = ((x1 * x1 + y1 * y1) * (y2 - y3) + (x2 * x2 + y2 * y2) * (y3 - y1) + (x3 * x3 + y3 * y3) * (y1 - y2)) / D;
        double uy = ((x1 * x1 + y1 * y1) * (x3 - x2) + (x2 * x2 + y2 * y2) * (x1 - x3) + (x3 * x3 + y3 * y3) * (x2 - x1)) / D;

        Point center = new Point(ux, uy);
        return new Circle(center, Math.sqrt(center.distSq(a)));
    }

    public static Circle welzl(List<Point> P, int n, List<Point> R) {
        // 기저 사례: 점을 다 봤거나 경계점(R)이 3개가 된 경우
        if (n == 0 || R.size() == 3) {
            return getMinCircleWithBoundary(R);
        }

        Point p = P.get(n - 1);
        // 1. p를 제외한 점들로 원을 만든다
        Circle c = welzl(P, n - 1, R);

        // 2. p가 원 안에 있으면 그대로 반환
        if (c != null && c.contains(p)) {
            return c;
        }

        // 3. p가 원 밖에 있으면 p는 반드시 경계(R)에 포함되어야 함
        List<Point> nextR = new ArrayList<>(R);
        nextR.add(p);
        return welzl(P, n - 1, nextR);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Point> P = new ArrayList<>();
        List<Point> R = new ArrayList<>();

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double xcoord = Double.parseDouble(st.nextToken());
            double ycoord = Double.parseDouble(st.nextToken());
            P.add(new Point(xcoord, ycoord));
        }

        // 섞어 주어야 함 : 무작위
        Collections.shuffle(P);

        // 결과 계산 (Main 객체를 생성하여 비정적 메서드 호출)
        Circle result = welzl(P, P.size(), R);

        // 출력 형식 맞추기
        if (result != null) {
            System.out.printf("%.10f %.10f %.10f\n", result.center.x, result.center.y, result.radius);
        }


    }


}