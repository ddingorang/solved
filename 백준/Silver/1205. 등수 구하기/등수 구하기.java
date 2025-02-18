import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Integer> scores = new ArrayList<>();
        if (n > 0) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            while (st1.hasMoreTokens()) {
                scores.add(Integer.parseInt(st1.nextToken()));
            }
        }

        int rank = 1;
        for (int s : scores) {
            if (s > score) {
                rank++;
            } else {
                break;
            }
        }

        if (n == p && score <= scores.get(scores.size() - 1)) {
            System.out.println("-1"); // 순위표에 오를 수 없음
        } else {
            System.out.println(rank);
        }
    }
}
