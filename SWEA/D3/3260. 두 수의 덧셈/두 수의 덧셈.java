import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            int i_a = a.length() - 1;
            int i_b = b.length() - 1;
            int carry = 0;
            StringBuilder sb2 = new StringBuilder();

            // 뒤에서부터 한 자릿수씩 더하기 (자릿수가 달라도 처리 가능)
            while (i_a >= 0 || i_b >= 0 || carry > 0) {
                int sum = carry;

                if (i_a >= 0) sum += a.charAt(i_a--) - '0';
                if (i_b >= 0) sum += b.charAt(i_b--) - '0';

                sb2.append(sum % 10); // 현재 자릿수 저장
                carry = sum / 10;     // 다음 자리로 넘길 올림수
            }

            sb.append("#").append(i + 1).append(" ").append(sb2.reverse()).append("\n");
        }
        System.out.print(sb);
    }
}