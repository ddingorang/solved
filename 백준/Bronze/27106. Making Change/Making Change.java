import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int change = 100-n;

        int twentyfive = change / 25;
        change %= 25;

        int ten = change / 10;
        change %= 10;

        int five = change / 5;
        change %= 5;

        sb.append(twentyfive).append(" ").append(ten).append(" ").append(five).append(" ").append(change);
        System.out.println(sb);
    }
}