import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		//System.out.println(sb.toString());
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			char now = '0';
			int cnt = 0;
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j) != now) {
					cnt += 1;
					now = s.charAt(j);
				}
			}
			
			// 결과 출력
			sb.append("#").append(i+1).append(" ").append(cnt).append("\n");
			
		}
		
		System.out.println(sb.toString());
	}
}