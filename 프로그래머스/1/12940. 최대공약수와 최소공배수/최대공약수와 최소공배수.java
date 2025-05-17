class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int prevn = n;
        int prevm = m;
        while(m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        answer[0] = n;
        answer[1] = (prevn*prevm) / n;
        return answer;
    }
}