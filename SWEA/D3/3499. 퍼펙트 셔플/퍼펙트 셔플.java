import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++) {
                if(n % 2 == 0) { // 짝수개
                    if(j<n/2) {
                        q1.add(st.nextToken());
                    }
                    else {
                        q2.add(st.nextToken());
                    }
                }
                else { // 홀수개, 
                    if(j<n/2+1) { // 먼저 놓는 쪽에 한장 더 들어가게 하기 위해
                        q1.add(st.nextToken());
                    }
                    else {
                        q2.add(st.nextToken());
                    }
                }
            }

            sb.append("#").append(i+1).append(" ");

            while(true) {
                if(!q1.isEmpty()) { // q1 쪽을 먼저 올림
                    sb.append(q1.remove()).append(" ");
                }
                if(!q2.isEmpty()) {
                    sb.append(q2.remove()).append(" ");
                }
                if(q1.isEmpty()) { // 무조건 q1이 먼저 비워짐 / size가 q1>=q2이기 때문
                    break;
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}