import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int ddiff = d2 - d1;
        if(ddiff < 0) {
            ddiff = d2 + 30 - d1;
            m2--;
        }

        int mdiff = m2 - m1;
        if(mdiff < 0) {
            mdiff = m2 + 12 - m1;
            y2--;
        }

        int ydiff = y2 - y1;
        int daysdiff = ydiff * 360 + mdiff * 30 + ddiff;

        // 연차
        int whatYear = daysdiff / 360;
        int yv = 0;
        for(int i=1; i<=whatYear; i++) {
            yv += (15 + (i-1) / 2);
        }

        // 월차
        int mv = ydiff * 12 + mdiff;
        if(mv > 36) mv = 36;

        sb.append(yv).append(" ").append(mv).append("\n");
        sb.append(daysdiff).append("days");
        System.out.println(sb);

    }
}