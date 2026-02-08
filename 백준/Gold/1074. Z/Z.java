import java.util.*;
import java.io.*;

public class Main {

    static int count = 0;

    static void solve(double size, double r, double c) {
        if (size == 1) return; // 1x1 크기에 도달하면 종료

        double half = size / 2;
        double area = half * half; // 한 사분면의 넓이

        if (r < half && c < half) {
            // 1사분면: 아무것도 더하지 않고 이동
            solve(half, r, c);
        } else if (r < half && c >= half) {
            // 2사분면: 1사분면 넓이 더함
            count += area;
            solve(half, r, c - half); // 상대 좌표로 변환
        } else if (r >= half && c < half) {
            // 3사분면: 1, 2사분면 넓이 더함
            count += area * 2;
            solve(half, r - half, c);
        } else {
            // 4사분면: 1, 2, 3사분면 넓이 더함
            count += area * 3;
            solve(half, r - half, c - half);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        double t = Math.pow(2, n) * Math.pow(2, n);

        solve(t, r, c);

        System.out.println(count);
    }
}