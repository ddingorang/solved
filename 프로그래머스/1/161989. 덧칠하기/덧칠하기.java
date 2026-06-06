class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int covered = 0;
        for(int s : section){
            if(s < covered) {
                continue;
            }
            else {
                covered = s + m;
                answer += 1;
            }
        }
        return answer;
    }
}