import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
 
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++) {
 
            int bc = Integer.parseInt(br.readLine());
            int[] room = new int[bc];
            int maxBlanksForEachLevel = 0;
 
            st = new StringTokenizer(br.readLine());
 
            for(int i=0; i<bc; i++) {
                room[i] = Integer.parseInt(st.nextToken());
            }
 
            // 블럭들 중 최대 높이
            int max = Arrays.stream(room)
                    .max()
                    .getAsInt();
 
            // 층마다 가로로 선을 그어서, 블럭이 지나지 않는(공백) 칸의 개수를 세어본다
            // (공백 수) - (가장 왼쪽의 블럭과 왼쪽 벽 사이의 공백 수) = 그 층에서의 가장 큰 낙차
            for(int k=1; k<=max; k++) {
                int temp = 0; // 공백 수 저장
                int left = 0; // 가장 왼쪽 블럭이 몇 열에 있는지(인덱스)
                boolean leftFound = false;
 
                for(int j=0; j<bc; j++) {
                    if(!leftFound && room[j] >= k) {
                        leftFound = true;
                        left = j; // 가장 왼쪽 블럭이 몇 열에 있는지 기록
                    }
                    if(room[j] < k) { // 해당 층에 블럭이 안 지나감
                        temp++; // 공백 수 증가
                    }
                }
                //System.out.println("blanks : " + temp);
                //System.out.println(temp-left);
 
                // 층마다 기록하고, 최대값만 남기기
                if(temp-left > maxBlanksForEachLevel) {
                    maxBlanksForEachLevel = temp-left;
                }
            }
 
            sb.append("#").append(tc+1).append(" ").append(maxBlanksForEachLevel).append("\n");
        }
 
        System.out.println(sb);
    }
}