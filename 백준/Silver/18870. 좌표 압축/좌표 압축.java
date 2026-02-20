import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> idx = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        int[] aftersort = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            num[i] = aftersort[i] = Integer.parseInt(st.nextToken());
        }

        // 순서대로 정렬
        // 0번째, 1번째, 2번째, ...
        Arrays.sort(aftersort);
        int order = 0;
        
        // 순서를 HashMap에 저장
        for(int i=0; i<n; i++) {
            if(idx.containsKey(aftersort[i])) continue; // 중복되는 수는 패스
            idx.put(aftersort[i], order++);
        }

        // 원본 배열에서 원소의 해당하는 순서를 HashMap에서 get
        for(int i=0; i<n; i++) {
            sb.append(idx.get(num[i])).append(" ");
        }

        System.out.println(sb);
    }
}
