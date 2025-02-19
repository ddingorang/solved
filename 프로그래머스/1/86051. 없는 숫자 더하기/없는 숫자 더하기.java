import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        List<Integer> doesnotexist = new ArrayList<>();
        Integer[] integerArray = new Integer[numbers.length];
        for(int i=0; i<numbers.length; i++){
            integerArray[i] = numbers[i];
        }
        for(int j=0; j<10; j++) {
            if(Arrays.asList(integerArray).contains(j) == false) {
                doesnotexist.add(j);
            }
        }
        int summ = doesnotexist.stream().mapToInt(Integer::intValue).sum();
        
        return summ;
    }
}