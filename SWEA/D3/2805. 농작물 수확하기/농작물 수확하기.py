import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int front = (n-1)/2;  int rear = (n-1)/2;
            boolean check = false;
            int summ = 0;
            for(int i=0; i<n; i++) {
                String s = br.readLine();
                for(int j=front; j<=rear; j++) {
                    summ += Integer.parseInt(String.valueOf(s.charAt(j)));
                }
                if(front == 0) {
                    check = true;
                }
                if(!check) {
                    front--;
                    rear++;
                }
                else if(check) {
                    front++;
                    rear--;
                }
            }

            sb.append("#").append(tc).append(" ").append(summ).append("\n");

        }

        System.out.println(sb);
    }
}