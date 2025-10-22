public class BestTimetoSellstock {

    public int maxProfit(int[] prices) {


        int buying=prices[0];

        int n= prices.length;
        int profit=0;

        for(int i=1;i<n;i++){

            if(prices[i] < buying){
                buying=prices[i];
            }
            else{
                profit=Math.max(profit,prices[i]-buying);

            }

        }

        return profit;

    }
}
