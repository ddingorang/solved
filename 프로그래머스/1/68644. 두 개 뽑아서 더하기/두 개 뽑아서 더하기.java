import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> set = new HashSet();
        for(int i = 0; i < numbers.length ; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                int summ = numbers[i] + numbers[j];
                set.add(summ);
            }
        }
        Integer[] result = set.toArray(new Integer[set.size()]);
        Arrays.sort(result);
        int[] resultToArray = Arrays.stream(result).mapToInt(Integer::intValue).toArray();
        return resultToArray;
    }
}