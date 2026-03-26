import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // [점수, 제출횟수, 시간, 참가자번호] 순으로 저장
        List<int[]> participants = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            int s = sc.nextInt();
            int c = sc.nextInt();
            int l = sc.nextInt();
            participants.add(new int[]{s, c, l, i});
        }
        
        // 정렬 조건 설정
        Collections.sort(participants, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; // 점수 내림차순
            if (a[1] != b[1]) return a[1] - b[1]; // 제출횟수 오름차순
            return a[2] - b[2];                  // 시간 오름차순
        });
        
        // 1등의 참가자 번호 출력
        System.out.println(participants.get(0)[3]);
    }
}