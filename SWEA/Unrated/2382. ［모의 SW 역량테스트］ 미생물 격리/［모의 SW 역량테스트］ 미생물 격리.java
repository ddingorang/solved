import java.io.*;
import java.util.*;

public class Solution {
    static int N, M, K;
    static int[] dr = {0, -1, 1, 0, 0}; // 상:1, 하:2, 좌:3, 우:4
    static int[] dc = {0, 0, 0, -1, 1};

    static class Cluster implements Comparable<Cluster> {
        int r, c, cnt, dir;

        public Cluster(int r, int c, int cnt, int dir) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dir = dir;
        }

        // 1. 좌표 순으로 정렬, 2. 좌표가 같으면 미생물 수 내림차순
        @Override
        public int compareTo(Cluster o) {
            if (this.r != o.r) return this.r - o.r;
            if (this.c != o.c) return this.c - o.c;
            return o.cnt - this.cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            List<Cluster> list = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                list.add(new Cluster(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                ));
            }

            // M시간 동안 이동 시뮬레이션
            for (int time = 0; time < M; time++) {
                for (int i = 0; i < list.size(); i++) {
                    Cluster cur = list.get(i);
                    cur.r += dr[cur.dir];
                    cur.c += dc[cur.dir];

                    // 약품 구역에 도달했을 때
                    if (cur.r == 0 || cur.r == N - 1 || cur.c == 0 || cur.c == N - 1) {
                        cur.cnt /= 2;
                        // 방향 반대로 (1<->2, 3<->4)
                        if (cur.dir == 1) cur.dir = 2;
                        else if (cur.dir == 2) cur.dir = 1;
                        else if (cur.dir == 3) cur.dir = 4;
                        else if (cur.dir == 4) cur.dir = 3;

                        if (cur.cnt == 0) { // 미생물이 다 죽으면 제거 대상
                            list.remove(i);
                            i--;
                        }
                    }
                }

                // 이동 후 정렬 (좌표순, 개수순)
                Collections.sort(list);

                // 같은 좌표 군집 합치기
                for (int i = 0; i < list.size() - 1; i++) {
                    Cluster current = list.get(i);
                    Cluster next = list.get(i + 1);

                    if (current.r == next.r && current.c == next.c) {
                        current.cnt += next.cnt; // 합치기
                        list.remove(i + 1); // 다음 놈 제거
                        i--; // 제거했으므로 인덱스 조정
                    }
                }
            }

            // 남은 미생물 합계 계산
            int total = 0;
            for (Cluster c : list) total += c.cnt;
            System.out.println("#" + tc + " " + total);
        }
    }
}