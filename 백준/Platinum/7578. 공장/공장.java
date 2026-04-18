import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] map = new int[1000001]; // 식별번호가 100만 이하
        int[] A = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int bNum = Integer.parseInt(st.nextToken());
            map[bNum] = i; // B 배열에서의 인덱스 저장
        }

        tree = new int[N + 1];
        long ans = 0;

        for (int i = 0; i < N; i++) {
            int pos = map[A[i]];
            // 현재 pos보다 뒤에 있는 연결된 케이블 개수 합산
            ans += query(N) - query(pos);
            // 현재 pos 위치를 '연결됨'으로 갱신
            update(pos, 1);
        }
        System.out.println(ans);
    }

    static void update(int i, int val) {
        for (; i <= N; i += i & -i) tree[i] += val;
    }

    static int query(int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i) sum += tree[i];
        return sum;
    }
}