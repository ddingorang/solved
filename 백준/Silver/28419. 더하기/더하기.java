import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        long odd = 0, even = 0;
        for(int i = 1; i <= n; i++){
            if(i % 2 == 0){
                even += Integer.parseInt(st.nextToken());
            }
            else {
                odd += Integer.parseInt(st.nextToken());
            }
        }
        if(n == 3 && odd > even) {
            System.out.println(-1);
        }
        else {
            System.out.println(Math.abs(odd-even));
        }

    }
}