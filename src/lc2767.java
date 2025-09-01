public class lc2767 {


    public int minimumBeautifulSubstrings(String s) {

        int n = s.length();

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = i; j >= 0; j++) {
                
                if (s.charAt(j) == '0') {
                    continue;
                }
                String str = s.substring(j, i);
                if (check(str)) {
                    dp[i] = dp[j] + 1;
                }
            }

        }

        return dp[n];

    }
    
    public boolean check(String s) {

        int num = Integer.parseInt(s, 2);


        while (num % 5 == 0) {
            num = num / 5;
            
        }
        



        return num==1;
    }
    















}