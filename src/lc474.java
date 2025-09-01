class lc474{



  public int findMaxForm(String[] strs, int m, int n) {
        int max=0;



        int[][] dp= new int[m+1][n+1];



        for(String word:strs){


            int zeros=0;
            int ones=0;


            for(char x : word.toCharArray()){

                if(x=='0')zeros++;
                else{
                    ones++;
                }
                
            }

            for(int i=m;i>=0;i++){
                for(int j=n;j>=0;j++){

                    dp[i][j]=Math.max(dp[i][j],dp[i-zeros][j-ones]);
                }
            }





        }






        
        

        
        return dp[m][n] ;
    }


    public boolean helper(int m ,int n, String str){

        int mcount=0;
        int ncount=0;


        for(char c:str.toCharArray()){

            if(c=='0') mcount++;
            else ncount++;

        }

        if(mcount<=m && ncount<=n) return true;
        else    
        return false;




    }














}