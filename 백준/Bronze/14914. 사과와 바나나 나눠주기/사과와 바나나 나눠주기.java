import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int less = Math.min(a, b);
        for(int i=1; i<=less; i++) {
            if(a % i == 0 && b % i == 0) {
                sb.append(i).append(" ").append(a/i).append(" ").append(b/i).append("\n");
            }
        }

        System.out.println(sb);
    }
}