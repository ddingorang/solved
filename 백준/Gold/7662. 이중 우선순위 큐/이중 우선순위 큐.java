import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (cmd == 'I') {
                    // 숫자 삽입 (이미 있으면 개수 +1)
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    // 삭제 명령 시 트리맵이 비어있으면 무시
                    if (map.isEmpty()) continue;

                    // n이 1이면 최댓값, -1이면 최솟값
                    int key = (n == 1) ? map.lastKey() : map.firstKey();
                    
                    int count = map.get(key);
                    if (count == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, count - 1);
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}