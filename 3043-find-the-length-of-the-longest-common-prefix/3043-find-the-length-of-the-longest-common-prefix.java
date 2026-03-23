class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        


        HashSet<Integer> hash= new HashSet<>();

        for(int i:arr1){

            while( i> 0){
                hash.add(i);

                i=i/10;
            }
        }

        int maxi=0;


        for(int i : arr2){


            while(i > 0){
                if(hash.contains(i)){
                    maxi=Math.max(String.valueOf(i).length(),maxi);

                    break;
                }
                  i/=10;

            }
        }

        return maxi;
    }
}