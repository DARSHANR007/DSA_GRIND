class Solution {
    public int[] sumZero(int n) {

        int[] res= new int[n];

        int index=0;

        if(n%2==1){

            res[index++]=0;

        }


        for(int i=1;index<n;i++){

            res[index++]=i;
            res[index++]=-i;
        }


        return res;
        
    }
}