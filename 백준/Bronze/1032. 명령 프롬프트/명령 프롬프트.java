import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        String[] strs = new String[n];
        for(int i = 0; i < n; i++){
            strs[i] = br.readLine();
        }

        for(int i=0; i<strs[0].length(); i++){
            boolean diff = false;
            for(int j=0; j<n-1; j++) {
                if(strs[j].charAt(i) != strs[j+1].charAt(i)){
                    diff = true;
                    sb.append("?");
                    break;
                }
            }
            if(!diff) {
                sb.append(strs[0].charAt(i));
            }

        }

        System.out.println(sb);

    }

}