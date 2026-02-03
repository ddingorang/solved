import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int front=0, rear=0;
        int sum = 0;
        int cnt = 0;
        while (true) {
            if (sum >= m) {
                // 현재 합이 m보다 크거나 같으면 front를 이동시켜 합을 줄임
                sum -= nums[front++];
            } else if (rear == n) {
                // sum이 m보다 작은데 이미 끝까지 도달했다면 더 이상 진행 불가
                break;
            } else {
                // 현재 합이 m보다 작으면 rear를 이동시켜 합을 키움
                sum += nums[rear++];
            }

            // 합이 m과 일치하는 순간 카운트 증가
            if (sum == m) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}