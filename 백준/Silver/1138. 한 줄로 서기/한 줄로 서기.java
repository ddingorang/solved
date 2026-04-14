import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] result = new int[N];
        for (int i = 1; i <= N; i++) {
            int leftCount = sc.nextInt(); // 왼쪽에 있어야 할 큰 사람 수
            for (int j = 0; j < N; j++) {
                // 내 자리를 찾기 위해 빈칸을 센다
                if (leftCount == 0 && result[j] == 0) {
                    result[j] = i;
                    break;
                } else if (result[j] == 0) {
                    leftCount--;
                }
            }
        }

        for(int r : result){
            System.out.print(r + " ");
        }
    }
}