import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        double dp[] = new double[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        ArrayList<Integer> testlist = new ArrayList<>();
        for(int i=0; i<testcase; i++) {
            int a = Integer.parseInt(br.readLine());
            testlist.add(a);
        }
        int maximum = Collections.max(testlist); // 테스트 케이스 중 최대값 구하기

        for(int j=6; j<=maximum; j++) { // 최대값까지 dp 배열 값 다 구해놓기
            dp[j] = dp[j-1] + dp[j-5];
            // j번째 도형 한 변의 길이 = j-1번째 도형 한 변의 길이 + j-5번째 도형 한 변의 길이
        }

        for(int e : testlist) {
            System.out.println(Math.round(dp[e]));
        }

    }
}