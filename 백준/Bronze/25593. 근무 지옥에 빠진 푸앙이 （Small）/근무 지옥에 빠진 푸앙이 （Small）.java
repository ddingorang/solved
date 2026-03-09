import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String inputN = br.readLine();
        if (inputN == null || inputN.isEmpty()) return;
        
        int n = Integer.parseInt(inputN);
        int[] hours = new int[] {4, 6, 4, 10};
        
        // 이름별 누적 시간을 저장할 Map
        HashMap<String, Integer> checkHours = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < hours.length; j++) {
                String line = br.readLine();
                
                // 빈 줄이 들어올 경우를 대비한 예외 처리
                if (line == null || line.trim().isEmpty()) {
                    continue; 
                }

                StringTokenizer st = new StringTokenizer(line);
                
                for (int k = 0; k < 7; k++) {
                    // 토큰이 남아있는지 확인하여 NoSuchElementException 방지
                    if (st.hasMoreTokens()) {
                        String curToken = st.nextToken();

                        if (curToken.equals("-")) {
                            continue;
                        }

                        // stream 대신 getOrDefault와 put 사용 (성능 및 가독성 최적화)
                        checkHours.put(curToken, checkHours.getOrDefault(curToken, 0) + hours[j]);
                    }
                }
            }
        }

        // 데이터가 아예 없는 경우 처리
        if (checkHours.isEmpty()) {
            // 문제 조건에 따라 데이터가 없을 때의 출력을 결정 (보통 Yes)
            System.out.println("Yes");
            return;
        }

        // stream 없이 최대/최소값 구하기 (직접 비교 방식)
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int time : checkHours.values()) {
            if (time < min) min = time;
            if (time > max) max = time;
        }

        // 결과 비교 및 출력
        if (max - min <= 12) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}