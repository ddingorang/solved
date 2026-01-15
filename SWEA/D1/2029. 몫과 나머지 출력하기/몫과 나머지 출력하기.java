
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		List<String> result = new ArrayList<>();
		
		for(int x = 0; x<a; x++) {
			int one = sc.nextInt();
			int two = sc.nextInt();
			int div = one / two;
			int left = one % two;
			result.add(div + " " + left);
		}
		
		for(int y = 0; y<result.size(); y++) {
			System.out.println("#" + (y+1) + " " + result.get(y));
		}
	}
}