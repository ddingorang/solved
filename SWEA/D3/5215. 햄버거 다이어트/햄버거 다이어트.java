import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int[] scores;
    static int[] calories;

    static boolean[] selected;
    static int maxcalories;

    static int resultmax;

    static void generateSubset(int cnt){
        if(cnt == scores.length) {
            int csum = 0;
            int ssum = 0;
            for(int i=0; i<n; i++) {
                if(selected[i]) {
                    csum += calories[i];
                    ssum += scores[i];
                }
            }

            if(csum <= maxcalories) {
                if(ssum > resultmax) {
                    resultmax = ssum;

                }
            }
            return;

        }

        // 선택
        selected[cnt] = true;
        generateSubset(cnt+1);

        // 선택 안함
        selected[cnt] = false;
        generateSubset(cnt+1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for(int i=0; i<tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            maxcalories = Integer.parseInt(st.nextToken());

            scores = new int[n];
            calories = new int[n];
            selected = new boolean[n];
            resultmax = -1;

            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                scores[j] = Integer.parseInt(st.nextToken());
                calories[j] = Integer.parseInt(st.nextToken());
            }

            // 재료를 구하는 부분집합 싹 다 구하기
            // 재료가 최대 20개 : 부분집합 개수 최대 2의 20승 = 1,048,576개
            generateSubset(0);

            sb.append("#").append(i+1).append(" ").append(resultmax).append("\n");
        }

        System.out.println(sb);
    }
}