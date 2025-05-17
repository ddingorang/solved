class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        String strx = String.valueOf(x);
        Integer summ = 0;
        for(int i = 0; i<strx.length(); i++) {
            char l = strx.charAt(i);
            String sl = String.valueOf(l);
            summ += Integer.parseInt(sl);
        }
        if(x % summ == 0) {
            answer = true;
        }
        
        return answer;
    }
}