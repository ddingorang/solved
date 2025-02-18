import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int curx = 0;
        int cury = 0;
        for(int k = 0; k < park[0].length(); k++) {
            for(int l = 0; l < park.length; l++) {
                if(park[l].charAt(k) == 'S') {
                    curx = l;
                    cury = k;
                }
            }
        }
        
        StringTokenizer st;
        Map<String, Integer[]> directions = new HashMap<>();
        directions.put("N", new Integer[]{-1, 0});
        directions.put("S", new Integer[]{1, 0});
        directions.put("W", new Integer[]{0, -1});
        directions.put("E", new Integer[]{0, 1});
        for(String r : routes) {
            st = new StringTokenizer(r);
            String direction = st.nextToken();
            Integer times = Integer.parseInt(st.nextToken());
            Integer[] movement = directions.get(direction);
            if(0 > (curx + movement[0]*times) || (curx + movement[0]*times) >= park.length || 0 > (cury + movement[1]*times) || (cury + movement[1]*times) >= park[0].length()) {
                continue;
            }
            boolean validMove = true;
            for(int i = 1; i < times+1; i++) {
                if(park[curx + movement[0]*i].charAt(cury + movement[1]*i) == 'X') {
                    validMove = false;
                    break;
                }
            }
        
            if(validMove) {
                curx += movement[0] * times;
                cury += movement[1] * times;
            }
            
        }
        int[] answer = {curx, cury};
        return answer;
    }
}