class Solution {
    public long countSubstrings(String s, char c) {

        long count=0;

        for(char x:s.toCharArray()){
            if(x==c){
                count++;

            }
        }

        count=count*(count+1)/2;


        return count;
        
    }
}