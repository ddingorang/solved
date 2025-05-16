class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long current = x;
        for(int m = 0; m < n; m++) {
            answer[m] = (long) x * (m+1);
        }
        return answer;
    }
}