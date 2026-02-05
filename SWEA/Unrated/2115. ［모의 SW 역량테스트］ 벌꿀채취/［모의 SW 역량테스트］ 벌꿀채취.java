import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] nums;
    static boolean[] selected;
    static int maxvalue;

    static int resultmax;

    static void generateSubset(int cnt, int c){
        if(cnt == nums.length) {
            int temp = 0;
            int sumSquared = 0;
            for(int i=0; i<nums.length; i++) {
                if(selected[i]) {
                    temp += nums[i];
                    sumSquared += (nums[i] * nums[i]);
                }

            }
            if(temp <= c) {
                if(sumSquared > maxvalue) maxvalue = sumSquared;
                return;
            }
            else {
                return;
            }
        }

        // 선택
        selected[cnt] = true;
        generateSubset(cnt+1, c);

        // 선택 안함
        selected[cnt] = false;
        generateSubset(cnt+1, c);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for(int i=0; i<tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][n];
            resultmax = 0;
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int x=0; x<n; x++) {
                for(int y=0; y<n-m+1; y++) {
                    int[] one = new int[m];
                    for(int onex = 0; onex < m; onex++) {
                        one[onex] = board[x][onex+y];
                    }

                    for(int a=0; a<n; a++) {
                        for(int b=0; b<n-m+1; b++) {
                            if (x == a && Math.abs(y - b) < m) { // 겹치게 되는 경우 제외
                                continue;
                            }

                            int[] two = new int[m];
                            for(int twox = 0; twox < m; twox++) {
                                two[twox] = board[a][twox+b];
                            }

                            maxvalue = -1;
                            nums = one;
                            selected = new boolean[m];
                            // 첫 번째 일꾼의 벌통에서 채취
                            generateSubset(0, c);
                            int onemax = maxvalue;

                            maxvalue = -1;
                            nums = two;
                            selected = new boolean[m];
                            // 두 번째 일꾼의 벌통에서 채취
                            generateSubset(0, c);
                            int twomax = maxvalue;

                            int maxscore = onemax + twomax;
                            if(maxscore > resultmax) {
                                resultmax = maxscore;
                            }
                        }
                    }
                }
            }

            sb.append("#").append(i+1).append(" ").append(resultmax).append("\n");

        }

        System.out.println(sb);
    }
}