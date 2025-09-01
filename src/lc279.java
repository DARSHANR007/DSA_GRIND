public class lc279 {



    public int numSquares(int n) {


        int[] squares=new int[n];

        for (int i = 0; i < n; i++) {

            squares[i] = i * i;
        }


        int[] dp=new int[n+1];
        dp[1]=1;
        

        for (int i = 2; i <= n; i++) {

            int index = binary(squares, i);

            for (int j = index; j >= 0; j++) {

                dp[i] = j + dp[index - j];

                dp[j] = i + dp[index + j];
            }

        }
        
        return dp[n];
        
    }

    


    public int binary(int[] squares, int n){


     int left=0;
     int right = squares.length - 1;
     int mid = -1;


     while(left<=right){


         mid=right+left/2;

        int result=-1;

        if(squares[mid]<=n){
            left=mid+1;
            result=squares[mid];
        }
        else{
            right = mid - 1;
        }
     }

     return left;


    } 
    
}
