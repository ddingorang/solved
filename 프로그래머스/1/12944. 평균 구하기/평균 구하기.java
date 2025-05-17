import java.util.*;
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double summ = Arrays.stream(arr).sum();
        answer = summ / arr.length;

        return answer;
    }
}