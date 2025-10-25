public class coinChange2 {


    public int change(int amount, int[] coins) {

        int n=coins.length;


        int[][] dp= new int[n+1][amount+1];


        for(int i=0; i<=n;i++){
            for(int j=0;j<=amount;j++ ){

                if( coins[i] <= j){
                    dp[i][j]= dp[i-1][j]+dp[i][i-j];
                }
            }
        }



        



        return  dp[n][amount];



    }
}
