import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: 재우와 피클 사이의 사람 수 N
        String input = br.readLine();
        if (input == null) return;
        int N = Integer.parseInt(input);

        StringBuilder sb = new StringBuilder();

        // 출력 첫 줄: 몇 번에 나누어 제칠 것인가? (N번)
        sb.append(N).append("\n");

        // 출력 둘째 줄: 각 회차마다 몇 명씩 제칠 것인가? (전부 1명씩)
        for (int i = 0; i < N; i++) {
            sb.append(1).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}