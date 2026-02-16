import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Integer[] cables = new Integer[k];

        for(int i=0; i<k; i++) {
            cables[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cables, Collections.reverseOrder());

        long front = 1;
        long rear = cables[0];
        long temp = 0;
        while(front <= rear) {
            long mid = (front + rear)/2;
            if(mid==0) break;

            int tmpcables = 0;
            for(int i=0; i<k; i++) {
                tmpcables += (cables[i] / mid);
            }

            if(tmpcables >= n) {
                temp = mid;
                front = mid + 1;
            }
            else {
                rear = mid - 1;
            }
        }

        System.out.println(temp);
    }
}