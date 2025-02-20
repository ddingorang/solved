import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first=br.readLine();
        String second=br.readLine();
        String third=br.readLine();
        List<String> colors = new ArrayList<String>(Arrays.asList("black", "brown",
                "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"));
        int ten = colors.indexOf(first);
        int one = colors.indexOf(second);
        int index = colors.indexOf(third);
        long total = (long) ((ten * 10 + one) * Math.pow(10, index));
        System.out.println(total);

    }
}