import java.util.Arrays;

public class PartitionBeautifulStrings {


    public int dp_solution(String s, int n) {

        int[] dp = new int[n + 1];

        Arrays.fill( dp   , 100);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = i - 1; j >= 0; j++) {

                String curr = s.substring(j, i);

                int val = Integer.parseInt(curr, 2);
                
                if (s.charAt(j) == '0') {
                    continue;
                    
                }

                if (isPowerOf(val, 5)) {

                    dp[i] = Math.min(dp[i], dp[j] + 1);
    


                }

            }

        }

         return dp[n] == 100 ? -1 : dp[n]; 
    }
    
     public static boolean isPowerOf(int n, int k) {
        if (n <= 0 || k <= 1) return n == 1;

        while (n % k == 0) {
            n /= k;
        }

        return n == 1;
    }


    





    








}