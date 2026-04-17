import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열의 크기
            String input = br.readLine(); // [1,2,3,4] 형태의 문자열

            // Deque에 숫자만 추출해서 담기
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(input, "[],");
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            System.out.println(solve(p, deque));
        }
    }

    private static String solve(String p, ArrayDeque<Integer> deque) {
        boolean isReverse = false;

        for (char cmd : p.toCharArray()) {
            if (cmd == 'R') {
                isReverse = !isReverse;
            } else { // 'D'인 경우
                if (deque.isEmpty()) {
                    return "error";
                }
                
                if (isReverse) {
                    deque.removeLast(); // 역방향이면 뒤에서 제거
                } else {
                    deque.removeFirst(); // 정방향이면 앞에서 제거
                }
            }
        }

        // 결과 출력 포맷 맞추기
        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
            sb.append(isReverse ? deque.removeLast() : deque.removeFirst());
            if (!deque.isEmpty()) sb.append(",");
        }
        sb.append("]");
        
        return sb.toString();
    }
}