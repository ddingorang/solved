import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<10; i++) {

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<8; j++) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }

            int inc = 1;
            while(true) {
                 if(inc == 6) inc = 1; // 한 싸이클 이후에 1로 초기화

                 Integer out = dq.poll(); // 먼저 앞에서 빼고
                 if(out-inc <= 0) { // 0 이하가 되면 중단
                     dq.offer(0);
                     break;
                 }
                 else {
                     dq.offer(out-inc); // 감소시키고 뒤에 넣기
                 }
                 inc++;

            }

            sb.append("#").append(i+1).append(" ");

            for(int k=0; k<8; k++) {
                sb.append(dq.poll()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}