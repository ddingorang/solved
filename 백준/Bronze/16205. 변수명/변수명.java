import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();

        String[] strs = new String[3];

        // camel case
        if(n==1) {
            strs[0] = s;
            StringBuilder sb2 = new StringBuilder();
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                    sb2.append("_").append((char)(s.charAt(i)+32)); // 소문자 변환
                }
                else {
                    sb2.append(s.charAt(i));
                }
            }

            strs[1] = sb2.toString();
            String firstletter = String.valueOf(s.charAt(0)).toUpperCase();
            strs[2] = firstletter + s.substring(1);
        }

        // snake case
        else if(n==2) {
            StringBuilder sb1 = new StringBuilder();
            boolean found = false;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '_') {
                    found = true;
                    continue;
                }
                if(found) {
                    sb1.append((char)(s.charAt(i) - 32));
                    found = false;
                }
                else {
                    sb1.append(s.charAt(i));
                }
            }
            strs[0] = sb1.toString();
            strs[1] = s;
            String firstletter = String.valueOf(strs[0].charAt(0)).toUpperCase();
            strs[2] = firstletter + strs[0].substring(1);
        }

        // pascal case
        else if(n==3) {
            String firstletter = String.valueOf(s.charAt(0)).toLowerCase();
            strs[0] = firstletter + s.substring(1);

            StringBuilder sb2 = new StringBuilder();
            for(int i=0; i<strs[0].length(); i++) {
                if(strs[0].charAt(i) >= 65 && strs[0].charAt(i) <= 90) {
                    sb2.append("_").append((char)(s.charAt(i)+32)); // 소문자 변환
                }
                else {
                    sb2.append(strs[0].charAt(i));
                }
            }

            strs[1] = sb2.toString();
            strs[2] = s;
        }


        for(String str : strs) {
            System.out.println(str);
        }

    }
}