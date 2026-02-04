import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long power(long a, long b, long c) {
        // base case: 어떤 수의 0승은 1
        if (b == 0) return 1;

        // 지수를 절반으로 나누어 재귀 호출
        // O(logb)의 속도로 단축
        // b가 짝수일 때 : b^10 = b^5 * b^5
        // b가 홀수일 때 : b^11 = b^5 * b^5 * b
        long half = power(a, b / 2, c);

        // 중간 결과값을 제곱 (이때도 c로 나누어 크기 유지)
        long temp = (half * half) % c;

        // 지수가 홀수라면 a를 한 번 더 곱해줌
        if (b % 2 == 0) {
            return temp;
        } else { // 지수가 홀수
            return (temp * (a % c)) % c; // 또 나누어 주기
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(power(a, b, c));
    }
}