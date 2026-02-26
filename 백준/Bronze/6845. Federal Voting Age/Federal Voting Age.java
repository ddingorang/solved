import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] birthday = new int[3];
        LocalDate election = LocalDate.of(2007, 2, 27);

        for(int d = 0; d<n; d++) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++) {
                birthday[i] = Integer.parseInt(st.nextToken());
            }
            LocalDate date = LocalDate.of(birthday[0], birthday[1], birthday[2]);

            Period period = Period.between(date, election);
            if(period.getYears() >= 18) {
                sb.append("Yes").append("\n");
            }
            else {
                sb.append("No").append("\n");
            }
        }

        System.out.println(sb);

    }
}

