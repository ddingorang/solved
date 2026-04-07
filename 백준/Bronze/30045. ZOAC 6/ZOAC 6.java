import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i=0; i<t; i++) {
            String sentence = br.readLine();
            if(sentence.contains("01") || sentence.contains("OI")) cnt++;
        }

        System.out.println(cnt);
    }

}