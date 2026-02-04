import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // N이 주어지지 않거나 0인 경우 처리
        if (input == null || input.equals("0")) {
            System.out.println("divide by zero");
            return;
        }

        int N = Integer.parseInt(input);

        // N이 0보다 크면 결과는 무조건 1.00
        // 항상 1임.. n<=100에서는
        // (단, 나머지 입력값들을 읽어는 주어야 함)
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 소수점 둘째 자리까지 출력
        System.out.println("1.00");
    }
}