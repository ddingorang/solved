import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int winCount = 0;

        for (int i = 0; i < n; i++) {
            String skills = sc.next();
            // "CD" 패턴이 포함되어 있지 않으면 승리
            if (!skills.contains("CD")) {
                winCount++;
            }
        }
        System.out.println(winCount);
    }
}