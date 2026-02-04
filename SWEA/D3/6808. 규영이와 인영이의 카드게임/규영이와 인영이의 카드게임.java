import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int n = 9, r=9, c=0;
    static int[] b;
    static boolean[] v;
    static int[] kyu;
    static int[] inn;
    static int kyuwin; // 규영이 이긴 횟수
    static int kyulose; // 규영이 진 횟수

    static void perm(int cnt) {
        if(cnt == r) {
            int kyuscore = 0;
            int innscore = 0;
            // 점수 계산
            for(int idx = 0; idx<9; idx++) {
                if(kyu[idx] > b[idx]) {
                    kyuscore += (kyu[idx] + b[idx]);
                }
                else {
                    innscore += (kyu[idx] + b[idx]);
                }
            }

            if(kyuscore > innscore) kyuwin++; // 규영이 승리
            else if(kyuscore < innscore) kyulose++; // 규영이 패배
            c++;
            return;
        }
        
        // 규영이 카드 순열 생성
        for(int i=0; i<n; i++) {
            if(v[i]) continue;
            v[i] = true;

            b[cnt] = inn[i];
            perm(cnt+1);

            v[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {

            kyu = new int[9];
            inn = new int[9];
            kyuwin = 0;
            kyulose = 0;
            int[] check = new int[19];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<9; j++) { // 규영이 카드 저장
                int num = Integer.parseInt(st.nextToken());
                kyu[j] = num;
                check[num] = 1;
            }

            int idx = 0;
            for(int k=1; k<19; k++) { // 인영이 카드 저장
                if(check[k] == 0) {
                    inn[idx] = k;
                    idx++;
                }
            }

            b = new int[r];
            v = new boolean[n];
            c=0;
            perm(0); // 인영이 카드 순서 경우의 수
            
            sb.append("#").append(i+1).append(" ").append(kyuwin).append(" ").append(kyulose).append("\n");
        }

        System.out.println(sb);
    }
}