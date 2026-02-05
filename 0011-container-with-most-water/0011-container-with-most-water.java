class Solution {
    public int maxArea(int[] height) {

        int left=0;

        int right=height.length-1;


        int capacity=-1;



        while(left<=right){


            int maxi=Math.min(height[left],height[right]);
            int width=right-left;
            capacity=Math.max(capacity,maxi*width);

            if(height[left] < height[right]){
                left++;
            }
            
            else{
                right--;
            }
 

        }
        return capacity;
    }
}