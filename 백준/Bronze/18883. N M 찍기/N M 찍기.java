import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(cnt);
                if(j != m-1) {
                    sb.append(" ");
                }
                cnt++;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}