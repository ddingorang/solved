import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][][] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] field = new char[n][];
        // 열쇠가 6가지 = 비트가 6개 = 2의 6제곱 = 64
        v = new boolean[n][m][64];

        for(int i=0; i<n; i++) {
            String row = br.readLine();
            field[i] = row.toCharArray();
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                // 시작 위치 찾기
                if(field[i][j] == '0') {
                    // (x좌표, y좌표, 열쇠 보유 상태, 이동 거리)
                    v[i][j][0] = true;
                    q.offer(new int[] {i, j, 0, 0});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int curx = cur[0], cury = cur[1], curkey = cur[2], curdist = cur[3];

                        if (field[curx][cury] == '1') {
                            System.out.println(curdist); // 최단거리 출력 후 종료
                            return;
                        }

                        for (int d = 0; d < 4; d++) { // i++ -> d++ 수정
                            int nx = curx + dx[d];
                            int ny = cury + dy[d];

                            // 범위 체크 및 벽('#') 통과 불가 체크
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m || field[nx][ny] == '#') continue;

                            int nextKey = curkey;
                            char cell = field[nx][ny];

                            // A. 열쇠인 경우
                            if (cell >= 'a' && cell <= 'f') {
                                nextKey |= (1 << (cell - 'a'));
                                // 알파벳 순서대로 왼쪽으로 1비트씩 밀기
                                // a이면 000001, b이면 000010, c이면 000100, ...
                                // 기존 키 보유 목록에, 새로운 키 합집합(OR) 연산
                                // 기존 : 000001(a만 보유)
                                // 추가 : 001100(c, d 추가)
                                // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
                                // 결과 : 001101(a, c, d키 보유)
                            }

                            // B. 문인 경우 (열쇠가 없으면 못 지나감)
                            else if (cell >= 'A' && cell <= 'F') {
                                if ((nextKey & (1 << (cell - 'A'))) == 0) continue;
                                // 키를 보유하는지 확인 : 교집합(AND) 연산
                                // 기존 : 001100(c, d 보유)
                                // 필요 : 001000(C 문을 열어야 함)
                                // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
                                // 결과 : 001000(c 키를 보유)
                            }

                            // 공통: 방문하지 않은 상태(현재 열쇠 조합 기준)라면 큐에 삽입
                            if (!v[nx][ny][nextKey]) {
                                v[nx][ny][nextKey] = true;
                                q.offer(new int[]{nx, ny, nextKey, curdist + 1});
                            }
                        }
                    }

                    // 큐가 빌 때까지 '1'을 못 만나면 탈출 불가
                    System.out.println("-1");
                }
            }
        }

    }

}



