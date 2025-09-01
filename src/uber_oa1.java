public class uber_oa1 {


    public int dp_solution(int n, int b[], int c[]) {
       

        int dp[][][] = new int[n+1][n+1][n+1];
        


        dp[1][1][1] = b[0];

        dp[1][1][2] = b[0];

        dp[1][2][1]= c[0];
        
        dp[1][2][2] = c[0];



        for (int i = 2; i <= n; i++) {


            dp[i][1][1]=b[i]+b[i-1]+Math.max(dp[i][1])   //+ [I-1]  we use this instead of dp[i-1] because it can become adjacent
                                                         // we cant confirm with dp[i-1 ] so we directly take  the previous value and 
                                                         // the alternate value even before that
                                                         




        }




        return 0;
    }




   
    
}
