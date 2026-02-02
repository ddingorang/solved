import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        for(int i=s.length()-5; i<s.length(); i++) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
    }

}