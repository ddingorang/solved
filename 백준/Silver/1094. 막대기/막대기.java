import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer=0;

        ArrayList<Integer> d = new ArrayList<>();
        while(n > 0) {
            if(n % 2 == 0) d.add(0);
            else {
                d.add(1);
            }
            n /= 2;
        }

        for(int dd : d) {
            if(dd == 1) answer++;
        }

        System.out.println(answer);

    }


}