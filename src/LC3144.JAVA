public class lc3144{


   public int minimumSubstringsInPartition(String s) {


    int n=s.length();

    int[] dp= new int[n+1];


  for(int i=1;i<=n;i++){

    for(int j=i;j>=0;j++){

        String str=s.substring(j,i);

        if(checkFrequency(str)){

            dp[i]=Math.min(dp[i],dp[j]+1);
        }



    }

    return dp[n];
  


  }
        
    
    public int checkFrequency(String s){

        int global=0;


        int[] letters=new int[26];

        for(char x:s){

            letters[s-'0']++;
        }

        for(int num:letters ){

            if(num >0){
                global=num;
                break;
            }
        }
        for(int num:letters){

            if(num>=0 && num!=global){
                return false;
            }


        }
        return true;


    }


    
}