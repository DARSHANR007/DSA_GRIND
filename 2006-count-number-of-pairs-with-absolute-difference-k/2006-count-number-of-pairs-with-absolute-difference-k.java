class Solution {
    public int countKDifference(int[] nums, int k) {


        HashMap<Integer,Integer> hash= new HashMap<>();

        int count=0;

        for(int x:nums){

            hash.put(x,hash.getOrDefault(x,0)+1);
        }


        for(int x: hash.keySet()){

            if( hash.containsKey(x+k)){
                count+=hash.get(x)*hash.get(x+k);
            }
        }

        return count;







        


    }


}