import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextLong();
        long m = sc.nextLong();
        
        // 핵심 로직: N이 M보다 크거나 같으면 결과는 항상 0
        if (n >= m) {
            System.out.println(0);
            return;
        }
        
        // N < M인 경우에만 팩토리얼 계산
        long result = 1;
        for (long i = 1; i <= n; i++) {
            result = (result * i) % m; // 매 곱셈마다 모듈러 연산 적용 (오버플로우 방지)
            
            // 최적화: 중간에 0이 되면 더 이상 계산할 필요 없음
            if (result == 0) break;
        }
        
        System.out.println(result);
    }
}