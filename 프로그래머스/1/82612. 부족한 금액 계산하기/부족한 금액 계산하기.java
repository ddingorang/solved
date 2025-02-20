class Solution {
    public long solution(int price, int money, int count) {
        Long sum = 0L;
        for(int i=1; i<=count; i++) {
            sum += i;
        }
        Long costs = price * sum;
        Long answer = 0L;
        if(costs - money > 0) {
            answer = costs - money;
        }

        return answer;
    }
}