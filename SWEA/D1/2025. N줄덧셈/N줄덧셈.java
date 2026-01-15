import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int temp=0;
		
		for(int i=1; i<=a; i++) {
			temp += i;
		}
		
		System.out.println(temp);
		
	}
}