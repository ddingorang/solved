import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            // 플로이드-워셜
            int[][] dist = new int[n+1][n+1];
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++) {
                    // 자기 자신과의 거리 = 0
                    if(i==j) dist[i][j] = 0;
                    // 거리 무한대로 초기화
                    else {
                        dist[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            for(int i=0; i<m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // 주어진 키 대소 비교 저장
                dist[a][b] = 1;
            }

            // 모든 학생을 거쳐가며 비교한다. 누가 누구보다 작은지
            for(int k=1; k<n+1; k++) {
                for(int i=1; i<n+1; i++) {
                    for(int j=1; j<n+1; j++) {
                        // i가 k보다 작고, k도 j보다 작으면
                        // i가 j보다 작은 것이 확실
                        if(dist[i][k] == 1 && dist[k][j] == 1) {
                            dist[i][j] = 1;
                        }
                    }
                }
            }

            int answer = 0;
            for(int k=1; k<n+1; k++) {
                int temp = 0;
                // 나보다 작은 사람
                for(int i=1; i<n+1; i++) {
                    if(dist[k][i] == 1) temp++;
                }
                // 나보다 큰 사람
                for(int i=1; i<n+1; i++) {
                    if(dist[i][k] == 1) temp++;
                }

                // 나보다 작은 사람 + 큰 사람이 밝혀진 개수가 n-1개라면
                // 모든 사람과 키 비교를 한 것이므로 내가 몇 번째로 큰 것인지 파악한 것이다
                if(temp == n-1) answer++;
            }

            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}