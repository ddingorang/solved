import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[] arr = new int[10];
        int[] result = new int[T];
        
        for (int test_case = 0; test_case < T; test_case++)
        {
            // Read 10 integers for each test case
            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }

            // Calculate the sum of odd numbers
            int temp = 0;
            for (int x : arr) {
                if (x % 2 == 1) {
                    temp += x;
                }
            }
            result[test_case] = temp;
        }
        
        // Print the results
        for (int j = 0; j < T; j++) {
            System.out.printf("#%d %d\n", j + 1, result[j]);
        }
    }
}
