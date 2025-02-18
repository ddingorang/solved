class Solution {
    public int solution(String[] babbling) {
        String[] possible = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for (String bab : babbling) {
            boolean isValid = true;
            
            // 각 발음 문자열을 처리
            for (String pos : possible) {
                // 연속된 발음이 있으면 무효 처리
                if (bab.contains(pos + pos)) {
                    isValid = false;
                    break;
                }
                // 발음을 제거
                bab = bab.replace(pos, " ");
            }

            // bab가 비어 있고 유효한 경우만 카운트
            if (bab.trim().isEmpty() && isValid) {
                answer += 1;
            }
        }

        return answer;
    }
}
