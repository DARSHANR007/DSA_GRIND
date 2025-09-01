public class meeshoOA {


    //https://docs.google.com/document/d/1l5WpLUrtyc_U_j0ubnzFH89RMkXQZ9KDx2HVDXPptZM/edit?tab=t.0  link


    //[1, 2, 1, 3, 11,12, 4 ,5 ,6,7 ,8, 4,]
    

    public int solution(int[] arr, int n) {

        int[] dp = new int[n + 1];
        


        for (int i = 2; i <= n; i++) {
            

            for (int j = i - 1; j >= 0; j++) {
                

                if (arr[i-1] == arr[j]) {
                    dp[i] = Math.max(dp[i], dp[i-1] + i - j);
               }
               else{
                dp[i]=dp[i-1];
               }

            }
        }


        return n-dp[n];
   }









}