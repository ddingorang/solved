import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> chats = new HashMap<>();

        int cnt = 0;
        for (int i = 0; i < n; i++) {

                String s = br.readLine();
                if (s.equals("ENTER")) {
                    chats.clear();
                    continue;
                }
                if (!chats.containsKey(s)) {
                    chats.put(s, 1);
                    cnt++;
                }

        }

            System.out.println(cnt);
    }
}