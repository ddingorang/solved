import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static final String OPERATORS = "+-*/";

    public static boolean isOperator(String token) { // 피연산자인지 판단
        return token.length() == 1 && OPERATORS.contains(token);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 사칙연산 유효성 검사
        // 내부 노드 : 전부 연산자여야 함
        // 말단 노드 : 전부 피연산자여야 함
        for (int tc = 1; tc <= 10; tc++) {
            int possible = 1;
            int t = Integer.parseInt(br.readLine());
            for(int i=0; i<t; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                String s = st.nextToken();
                if(idx<=t/2) { // 내부 노드
                    if(!isOperator(s)){
                        possible = 0;
                    }
                }
                else { // 말단 노드
                    if(isOperator(s)) {
                        possible = 0;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(possible).append("\n");

        }

        System.out.println(sb);
    }
}