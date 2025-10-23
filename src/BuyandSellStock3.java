public class BuyandSellStock3 {

    public int maxProfit(int[] prices) {


        int maxi1=-1;

        int maxi2=-1;



        int buyingPrice=prices[0];

        int n=prices.length;


        for(int i=1;i<n;i++){

            int price=prices[i];

            if( price <  buyingPrice){
                buyingPrice=price;
            }
            else {
                int currProfit=0;
                currProfit=price-buyingPrice;

                buyingPrice=price;

                if(currProfit > maxi1){
                    maxi1=currProfit;
                } else if ( currProfit > maxi2 && currProfit < maxi1) {
                    maxi2=currProfit;

                }
            }
        }


        return maxi1+maxi2;

    }
}