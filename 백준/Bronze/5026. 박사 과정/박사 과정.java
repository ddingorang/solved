import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            if(s.equals("P=NP")) {
                sb.append("skipped").append("\n");
                continue;
            }
            String[] strs = s.split("\\+");
            int temp = 0;
            for(String str : strs) {
                temp += Integer.parseInt(str);
            }
            sb.append(temp).append("\n");

        }
        System.out.println(sb);
    }
}