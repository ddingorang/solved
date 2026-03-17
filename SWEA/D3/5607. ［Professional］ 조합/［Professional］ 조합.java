import java.util.Scanner;

public class Solution {
    static long P = 1234567891;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // 팩토리얼 미리 계산
        long[] fact = new long[1000001];
        fact[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            fact[i] = (fact[i - 1] * i) % P;
        }

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int R = sc.nextInt();

            long numerator = fact[N]; // 분자
            long denominator = (fact[R] * fact[N - R]) % P; // 분모

            // 분모의 (P-2)승 계산
            // 나머지 연산(mod)은 나눗셈에는 적용이 안된다
            // 페르마의 소정리
            // a^(P-2) == (1/a) (mod P)
            // P가 소수이고, a가 P의 배수가 아닐 때
            long invDenominator = power(denominator, P - 2);

            long ans = (numerator * invDenominator) % P;
            System.out.println("#" + t + " " + ans);
        }
    }

    // 분할 정복을 이용한 거듭제곱
    static long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1) res = (res * a) % P;
            a = (a * a) % P;
            b /= 2;
        }
        return res;
    }
}