import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int i=0; i<tc; i++) {

            Map<String, Integer> styles = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // 의상 이름은 사용할 곳이 없음
                String type = st.nextToken(); // 의상 종류

                // 해당 종류가 이미 있으면 +1, 없으면 1로 저장
                styles.put(type, styles.getOrDefault(type, 0) + 1);
            }

            // 조합 계산
            int result = 1;

            // 조합의 개수
            // (각 의상 타입의 개수 + 1)을 곱해 나감
            // (n + 1)(n1 + 1)(n2 + 1)...
            // 맨 마지막에 -1 -> 알몸인 경우를 제외
            //(n + 1)(n1 + 1)(n2 + 1)... - 1


            // 맵에 저장된 각 종류별 개수(val)를 순회
            for (int val : styles.values()) {
                result *= (val + 1); // (해당 종류의 옷 개수 + 안 입는 경우 1)
            }

            // 알몸인 상태(모두 안 입는 경우 1가지)를 빼고 결과 저장
            sb.append(result - 1).append('\n');
        }

        System.out.println(sb.toString());
    }

}