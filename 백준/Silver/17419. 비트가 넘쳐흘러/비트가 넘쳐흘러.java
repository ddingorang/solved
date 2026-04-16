import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N은 사용하지 않아도 무방합니다.
        int N = Integer.parseInt(br.readLine());
        String K = br.readLine();
        
        int count = 0;
        for (int i = 0; i < K.length(); i++) {
            if (K.charAt(i) == '1') {
                count++;
            }
        }
        
        System.out.println(count);
    }
}