import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 1;
        int cnt = 0;
        while (n != 0) {
            if (num > n) num = 1;
            n -= num;
            cnt++;
            num++;
        }

        System.out.println(cnt);
    }


}