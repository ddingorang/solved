import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;

            st = new StringTokenizer(br.readLine());
            int[] items = new int[n];
            for(int i=0; i<n; i++) {
                items[i] = Integer.parseInt(st.nextToken());
            }

            int max = -1;
            for(int i=0; i<n-1; i++) {
                for(int j=i+1; j<n; j++) {
                    int tmpsum = items[i] + items[j];
                    if(tmpsum > max && tmpsum <= m) max = tmpsum;
                }
            }

            if(max == -1) {
                System.out.println("NONE");
            }
            else {
                System.out.println(max);
            }

        }
    }
}
