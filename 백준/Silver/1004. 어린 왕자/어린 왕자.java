import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int getThrough = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                // 출발점이 행성 내부에 있는지 여부 (거리가 반지름보다 작으면 true)
                boolean startInside = Math.pow(x1 - cx, 2) + Math.pow(y1 - cy, 2) < Math.pow(r, 2);
                // 도착점이 행성 내부에 있는지 여부
                boolean endInside = Math.pow(x2 - cx, 2) + Math.pow(y2 - cy, 2) < Math.pow(r, 2);

                // 두 조건 중 하나만 만족할 때(XOR) 진입/이탈이 발생함
                if (startInside != endInside) {
                    getThrough++;
                }
            }
            sb.append(getThrough).append("\n");
        }
        System.out.print(sb);
    }
}