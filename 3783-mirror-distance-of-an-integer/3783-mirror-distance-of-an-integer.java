class Solution {
    public int mirrorDistance(int n) {

        String str=String.valueOf(n);
        String reversed = new StringBuilder(str).reverse().toString();

        int num=Integer.parseInt(reversed);

        return Math.abs(num-n);

        
        
    }
}