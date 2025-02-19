class Solution {
    public int solution(int a, int b, int n) {
        int cokeleft = n;
        int blankcoke = 0;
        int newcoke = 0;
        int cokeacc = 0;
        while(true) {
            blankcoke = (cokeleft/a)*a; // 비워진 콜라
            newcoke = (cokeleft/a)*b; // 다시 받는 콜라
            cokeleft -= blankcoke;
            cokeleft += newcoke;
            cokeacc += newcoke;
            if (cokeleft < a) {
                break;
            } 
                    
        }
        
        return cokeacc;
    }
}