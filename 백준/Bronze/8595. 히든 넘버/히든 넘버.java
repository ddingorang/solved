import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 문자열 길이
        String s = sc.next(); // 문자열

        long totalSum = 0;
        long currentNumber = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // 숫자인 경우 계속 이어 붙임
                currentNumber = currentNumber * 10 + (c - '0');
            } else {
                // 문자를 만나면 지금까지의 숫자를 더하고 초기화
                totalSum += currentNumber;
                currentNumber = 0;
            }
        }

        // 마지막에 남아있는 숫자까지 더해줌
        totalSum += currentNumber;

        System.out.println(totalSum);
    }
}