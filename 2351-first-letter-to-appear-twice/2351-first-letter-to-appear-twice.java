class Solution {
    public char repeatedCharacter(String s) {

        int mask=0;

        

        for (char x : s.toCharArray()) {

            int bit=1 << (x-'a');


            if( (bit & mask) !=0) return x;


            mask|=bit;



           
        }

        return ' '; 
    }
}
