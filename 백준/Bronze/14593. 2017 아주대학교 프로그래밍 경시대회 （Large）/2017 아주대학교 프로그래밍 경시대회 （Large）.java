import java.util.*;
import java.io.*;

class Candidate implements Comparable<Candidate> {
    int id, s, c, l;

    public Candidate(int id, int s, int c, int l) {
        this.id = id;
        this.s = s;
        this.c = c;
        this.l = l;
    }

    @Override
    public int compareTo(Candidate o) {
        // 1. 점수 내림차순
        if (this.s != o.s) {
            return o.s - this.s;
        }
        // 2. 제출 횟수 오름차순
        if (this.c != o.c) {
            return this.c - o.c;
        }
        // 3. 마지막 제출 시간 오름차순
        return this.l - o.l;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List<Candidate> list = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            list.add(new Candidate(i, s, c, l));
        }

        // 정렬 수행
        Collections.sort(list);

        // 정렬 후 첫 번째 사람이 우승자
        System.out.println(list.get(0).id);
    }
}