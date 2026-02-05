import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] letters = s.toCharArray();
        int[] counts = new int[5];

        for (char letter : letters) {
            if (letter == 'H') counts[0]++;
            else if (letter == 'I') counts[1]++;
            else if (letter == 'A') counts[2]++;
            else if (letter == 'R') counts[3]++;
            else if (letter == 'C') counts[4]++;
        }

        int min = Arrays.stream(counts).min().orElse(Integer.MIN_VALUE);

        System.out.println(min);
    }
}