import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] ppl = new int[n];
        for(int i = 0; i < n; i++) {
            ppl[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        while(true) {
            int max = -1;
            int maxidx = -1;
            for(int i = 0; i < n; i++) {
                if(ppl[i] >= max) {
                    max = ppl[i];
                    maxidx = i;
                }
            }
            if(maxidx == 0) break;
            ppl[maxidx] -= 1;
            ppl[0] += 1;
            cnt += 1;
        }

        System.out.println(cnt);
    }
    
}