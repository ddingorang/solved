import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        
        int mod = 20000303;
        long result = 0;
        
        for (int i = 0; i < N.length(); i++) {
            result = (result * 10 + (N.charAt(i) - '0')) % mod;
        }
        
        System.out.println(result);
    }
}
