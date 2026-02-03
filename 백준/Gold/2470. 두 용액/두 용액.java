import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> l = new ArrayList<>();
    static int front = 0;
    static int rear = -1;
    static long min = 2000000001;
    static int tmpf = -1;
    static int tmpr = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            l.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(l);
        rear = l.size()-1;

        while (front < rear) {
            int sum = l.get(front) + l.get(rear);

            // 1. 현재 합이 지금까지의 최소값보다 0에 더 가깝다면 정보를 저장
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                tmpf = front;
                tmpr = rear;
            }

            // 2. 합이 0보다 크면 합을 줄이기 위해 rear를 감소
            if (sum > 0) {
                rear--;
            }
            // 3. 합이 0보다 작으면 합을 키우기 위해 front를 증가
            else if (sum < 0) {
                front++;
            }
            // 4. 합이 정확히 0이라면 더 이상 찾을 필요가 없으므로 종료
            else {
                break;
            }
        }

        sb.append(l.get(tmpf)).append(" ").append(l.get(tmpr));
        System.out.println(sb);
    }
}
