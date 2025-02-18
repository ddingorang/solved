import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> scoremap = new HashMap<>();
        for(int i = 0; i<name.length; i++) {
            scoremap.put(name[i], yearning[i]);
        }
        List<Integer> result = new ArrayList<>();
        for(String[] p : photo) {
            int score = 0;
            for(String n : p) {
                if(scoremap.containsKey(n)) {
                    score += scoremap.get(n);
                }
            }
            result.add(score);
        }
        int[] resultarr = new int[result.size()];
        for(int j=0; j<result.size(); j++) {
            resultarr[j] = result.get(j);
        }
        return resultarr;
    }
}