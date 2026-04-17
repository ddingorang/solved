import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr, compressed;
    static long[] tree;
    static int S = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        int[][] temp = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            temp[i][0] = arr[i]; // 값
            temp[i][1] = i;      // 원래 인덱스
        }

        // 1. 좌표 압축 (값 기준 오름차순 정렬)
        Arrays.sort(temp, (a, b) -> a[0] - b[0]);
        compressed = new int[N];
        int rank = 1;
        for (int i = 0; i < N; i++) {
            // 중복된 값 처리 (문제 조건에 따라 동일 값은 순위 유지 가능하지만 
            // Inversion Count에서는 입력 순서를 고려해야 함)
            compressed[temp[i][1]] = i + 1; 
        }

        // 2. 트리 크기 설정
        while (S < N) S <<= 1;
        tree = new long[S * 2];

        long ans = 0;
        for (int i = 0; i < N; i++) {
            int val = compressed[i];
            // 현재 값보다 큰 값들이 이미 몇 개 들어왔는지 계산 (val+1 ~ N 구간합)
            ans += query(val + 1, N);
            // 현재 값 위치에 1 추가
            update(val, 1);
        }

        System.out.println(ans);
    }

    static void update(int target, int diff) {
        int idx = S + target - 1;
        while (idx > 0) {
            tree[idx] += diff;
            idx /= 2;
        }
    }

    static long query(int left, int right) {
        long sum = 0;
        int l = S + left - 1;
        int r = S + right - 1;

        while (l <= r) {
            if (l % 2 == 1) sum += tree[l++];
            if (r % 2 == 0) sum += tree[r--];
            l /= 2;
            r /= 2;
        }
        return sum;
    }
}