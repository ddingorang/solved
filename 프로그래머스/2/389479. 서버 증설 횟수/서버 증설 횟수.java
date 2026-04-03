class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] curstat = new int[24];
        for(int i=0; i<24; i++) {
            int minimum = players[i] / m;
            if(minimum > curstat[i]) {
                int needToAdd = minimum - curstat[i];
                answer += needToAdd;
                for(int j=i; j<i+k; j++) {
                    
                    if(j >= 24) break;
                    curstat[j] += needToAdd;
                }
            }
        }
        return answer;
    }
}