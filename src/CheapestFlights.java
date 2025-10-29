import java.util.Arrays;

public class CheapestFlights {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {



        //dp[k+1][city] = minimum cost to reach `city` using at most `k` flights.

        int[][] dp=new int[K+2][n];

        final int inf= 1000000000;


        for (int i = 0; i <= K + 1; i++) {
            Arrays.fill(dp[i], inf);
        }



        dp[0][src]=0;

        for(int i=1;i<=K+1;i++){

            for(int j=1;j<=n;j++){

                dp[i][j]=dp[i-1][j];


                for(int [] flight:flights){

                    int source=flight[0];
                    int destination=flight[1];
                    int cost=flight[2];


                    if(dp[i-1][source]!=inf && dp[i-1][source]+cost < dp[i][destination]){
                        dp[i][destination]=dp[i-1][source]+cost;
                    }

                }
            }



        }












        return dp[K + 1][dst] == inf ? -1 : dp[K + 1][dst];
    }
}
