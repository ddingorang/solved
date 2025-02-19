import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        int right = 0;
        int wrong = 0;
        for(int num : lottos) {
            boolean found = false;
            if(num != 0) {
                for(int wnum : win_nums) {
                    if(num == wnum) {
                        found = true;
                        right += 1;
                        break;
                    }
                }
                if(found==false) {
                    wrong += 1;
                }
            }
        }
        int zeros = 6 - right - wrong;
        int maximum = 6 - wrong;
        int minimum = right;
        int maxrank = 7 - maximum;
        int minrank = 7 - minimum;
        if(minrank >= 6) {
            minrank = 6;
        }
        if(maxrank >= 6) {
            maxrank = 6;
        }
        
        int[] answer = {maxrank, minrank};
        return answer;
    }
}