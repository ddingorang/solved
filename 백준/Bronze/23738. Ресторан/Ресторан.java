import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<Character, String> russian = new HashMap<>();
        russian.put('B', String.valueOf('v'));
        russian.put('E', "ye");
        russian.put('H', String.valueOf('n'));
        russian.put('P', String.valueOf('r'));
        russian.put('C', String.valueOf('s'));
        russian.put('Y', String.valueOf('u'));
        russian.put('X', String.valueOf('h'));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            if(russian.get(s.charAt(i)) != null) { // 러시아 철자일 경우 변환
                sb.append(russian.get(s.charAt(i)));
            }
            else { // 아니라면 소문자로 변환
                char small = Character.toLowerCase(s.charAt(i));
                sb.append(small);
            }

        }
        System.out.println(sb);

    }

}