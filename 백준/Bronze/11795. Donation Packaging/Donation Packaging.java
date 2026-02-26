import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] packages = new int[3];

        for(int d = 0; d<n; d++) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++) {
                packages[i] += Integer.parseInt(st.nextToken());
            }
            int min = Integer.MAX_VALUE;
            for(int i=0; i<3; i++) {
                if(min > packages[i]) min = packages[i];
            }

            if(min < 30) {
                sb.append("NO").append("\n");
            }
            else {
                for(int i=0; i<3; i++) {
                    packages[i] -= min;
                }
                sb.append(min).append("\n");
            }
        }

        System.out.println(sb);
        
    }
}

