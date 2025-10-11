public class USACO_famerJhon {

//    https://usaco.org/index.php?page=viewproblem2&cpid=574


    public double farmerJhon(int cap, int n, int[] weights, int[] talents){


        int [][]dp = new int[n+1][cap+1];

        int actualCount=1;


        for(int i=1;i<=n;i++){
            for(int j=1;j<=cap;j++){

                int curr=i-1;

                if( (talents[curr]+dp[i-1][j-weights[i]])/actualCount+1>dp[i-1][j]){
                    dp[i][j]=talents[curr]+dp[i-1][j-weights[i]]/actualCount++;
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }

            }
        }






        return 0;
    }
}
