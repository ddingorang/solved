import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[3];

        sb.append("Gnomes:").append("\n");
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }

            if((nums[2] - nums[1])*(nums[1] - nums[0]) < 0 ) {
                sb.append("Unordered").append("\n");
            }
            else {
                sb.append("Ordered").append("\n");
            }
        }
        System.out.println(sb);
    }

}