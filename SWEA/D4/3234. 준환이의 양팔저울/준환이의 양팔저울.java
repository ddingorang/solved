/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int N;
    static int[] weights;
    static boolean[] visited;
    static int count;
    
    static void backtrack(int cnt, int left, int right) {
    	
    	// 오른쪽 무게가 왼쪽보다 커지면 중단(백트래킹)
    	if(right>left) {
    		return;
    	}
    	
    	// 모두 다 올려놓았으면 count 증가, 종료
    	if(cnt==N) {
    		count++;
    		return;
    	}
    	
    	for(int k=0; k<N; k++) {
    		if(visited[k]) continue;
    		
    		visited[k] = true;
    		
    		// 왼쪽에 놓기
    		backtrack(cnt + 1, left + weights[k], right);
    		
    		// 오른쪽에 놓기
    		backtrack(cnt + 1, left, right+weights[k]);
    		
    		visited[k] = false;
    	}
    	
    }
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_d4_3234.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
			
		for(int tc = 1; tc <= T; tc++)
		{
			N = Integer.parseInt(br.readLine());
			weights = new int[N];
			visited = new boolean[N];
			count = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			
			backtrack(0, 0, 0);
			// 결과 출력
			sb.append("#").append(tc).append(" ").append(count).append("\n");
			

		}
		System.out.println(sb.toString());
		br.close();
	}
}