import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] words;
    static int maxWords = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        words = new int[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int mask = 0;
            for (char c : str.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            words[i] = mask;
        }

        // 초기 필수 글자 마스킹: a, n, t, i, c
        int baseMask = 0;
        baseMask |= (1 << ('a' - 'a'));
        baseMask |= (1 << ('n' - 'a'));
        baseMask |= (1 << ('t' - 'a'));
        baseMask |= (1 << ('i' - 'a'));
        baseMask |= (1 << ('c' - 'a'));

        backtracking(0, 0, baseMask);
        System.out.println(maxWords);
    }

    // index: 탐색할 알파벳 위치, count: 추가로 배운 글자 수, mask: 현재까지 배운 상태
    static void backtracking(int index, int count, int mask) {
        // K-5개를 모두 골랐을 때
        if (count == K - 5) {
            int readableCount = 0;
            for (int wordMask : words) {
                // 단어에 포함된 모든 글자가 배운 글자(mask)에 포함되는지 확인
                if ((wordMask & mask) == wordMask) {
                    readableCount++;
                }
            }
            maxWords = Math.max(maxWords, readableCount);
            return;
        }

        // 알파벳 'z'까지 탐색
        for (int i = index; i < 26; i++) {
            // 이미 배운 글자(a, n, t, i, c)는 건너뜀
            if ((mask & (1 << i)) == 0) {
                backtracking(i + 1, count + 1, mask | (1 << i));
            }
        }
    }
}