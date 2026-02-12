import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        for(int i=0; i<n; i++) {
            if(s.charAt(i) == 'I') sb.append("i");
            else if(s.charAt(i) == 'l') sb.append("L");
        }

        System.out.println(sb);

    }
}