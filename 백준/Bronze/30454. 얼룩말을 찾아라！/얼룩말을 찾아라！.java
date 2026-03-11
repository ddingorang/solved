import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] linecount = new int[n];
        for(int i=0; i<n; i++) {
            boolean oneappeared = false;
            int tempcnt = 0;
            String horse = br.readLine();
            char[] horses = horse.toCharArray();
            for(int j=0; j<horses.length; j++) {
                if(!oneappeared && horses[j] == '1') {
                    tempcnt++;
                    oneappeared = true;
                }
                else if(horses[j] == '0') {
                    oneappeared = false;
                }
            }
            linecount[i] = tempcnt;
        }

        int maxx = -1;
        for(int e: linecount){
            if(e > maxx) {
                maxx = e;
            }
        }

        int horsecount = 0;
        for(int e : linecount) {
            if(e == maxx) horsecount++;
        }

        System.out.println(maxx + " " + horsecount);
    }
}
