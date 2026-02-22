import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int sodaecount = (k + n - 1) / n;   // 정수 올림

        int whichjoong = (sodaecount - 1) / b + 1;
        int whichso = (sodaecount - 1) % b + 1;

        System.out.println(whichjoong + " " + whichso);
    }
}