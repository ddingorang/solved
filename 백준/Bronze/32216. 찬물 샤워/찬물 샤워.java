import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t0 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temp = new int[n];
        for(int i=0; i<n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        int curtemp = t0;
        int[] aftertemp = new int[n];
        for(int i=0; i<n; i++) {
            if(curtemp < k) {
                curtemp += temp[i] + Math.abs(curtemp - k);
            }
            else if(curtemp > k) {
                curtemp += temp[i] - Math.abs(curtemp - k);
            }
            else {
                curtemp += temp[i];
            }
            aftertemp[i] = curtemp;
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            answer += Math.abs(aftertemp[i] - k);
        }

        System.out.println(answer);

    }
}
