import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Integer[] landmarks = new Integer[N];
        for (int i = 0; i < N; i++) {
            landmarks[i] = Integer.parseInt(br.readLine());
        }

        // 1. 원점에서의 거리를 기준으로 정렬 (절댓값 오름차순)
        Arrays.sort(landmarks, (a, b) -> Math.abs(a) - Math.abs(b));

        int currentTime = 0;
        int currentPos = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            // 2. 다음 방문할 랜드마크까지의 거리 계산
            int nextPos = landmarks[i];
            int distance = Math.abs(nextPos - currentPos);

            // 3. 시간을 초과하는지 확인
            if (currentTime + distance <= T) {
                currentTime += distance;
                currentPos = nextPos;
                count++;
            } else {
                // 더 이상 방문 불가
                break;
            }
        }

        System.out.println(count);
    }
}