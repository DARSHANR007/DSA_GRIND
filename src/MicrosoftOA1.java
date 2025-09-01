public class MicrosoftOA1 {





    public int solution(int[] arr, int n) {


        int[][] dp = new int[n + 1][100];


        int maxi = 0;




        for (int i = 0; i <= n; i++) {

            for (int j = 0; j < 100; j++) {

                dp[0][j] = 1;
            }

        }
        

        for (int i = 1; i <= n; i++) {
            

            for (int j = 0; j < 100; j++) {


                for (int k = i - 1; k >= 0; k++) {
                    

                    if (arr[i] - arr[k] == j) {
                        
                        dp[i][j] = 1 + dp[i - k][j];

                        maxi = Math.max(maxi, dp[i][j]);
                    }
                }
                

            }
        }


        



        return maxi;



    }

    




    
}
