import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        while (T-- > 0) {
            String n = sc.next();
            int count = 0;

            while (!n.equals("6174")) {
                // 1. 4자리가 안 되면 0 채우기
                while (n.length() < 4) n = "0" + n;

                char[] chars = n.toCharArray();

                // 2. 오름차순 정렬 (최소수)
                Arrays.sort(chars);
                int min = Integer.parseInt(new String(chars));

                // 3. 내림차순 정렬 (최대수)
                // 정렬된 배열을 뒤집기 위해 StringBuilder 사용
                String sorted = new String(chars);
                String reversed = new StringBuilder(sorted).reverse().toString();
                int max = Integer.parseInt(reversed);

                // 4. 차이 계산 및 갱신
                n = String.valueOf(max - min);
                count++;
            }
            System.out.println(count);
        }
    }
}