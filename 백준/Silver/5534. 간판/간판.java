import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String target = br.readLine();
        int targetLen = target.length();
        int answer = 0;

        for (int k = 0; k < n; k++) {
            String oldSign = br.readLine();
            int oldLen = oldSign.length();
            boolean found = false;

            // 1. 시작 위치 (i)
            for (int i = 0; i < oldLen; i++) {
                if (oldSign.charAt(i) == target.charAt(0)) {
                    
                    // 2. 두 번째 글자 위치 (j)를 통해 간격(gap) 결정
                    for (int j = i + 1; j < oldLen; j++) {
                        if (oldSign.charAt(j) == target.charAt(1)) {
                            int gap = j - i;
                            
                            // 3. 정해진 간격으로 나머지 글자가 다 맞는지 확인
                            if (i + gap * (targetLen - 1) < oldLen) {
                                boolean ok = true;
                                for (int m = 2; m < targetLen; m++) {
                                    if (oldSign.charAt(i + gap * m) != target.charAt(m)) {
                                        ok = false;
                                        break;
                                    }
                                }
                                if (ok) {
                                    found = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (found) break;
            }
            if (found) answer++;
        }
        System.out.println(answer);
    }
}