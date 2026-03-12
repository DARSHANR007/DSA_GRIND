class Solution {
    public int wateringPlants(int[] plants, int capacity) {

        int bucket=capacity;

        int n=plants.length;
        int steps=0;
        int i=0;

        while(i < n){

            if(bucket>=plants[i]){
                bucket-=plants[i];
                steps++;
            }
            else if(plants[i] > bucket){

                steps+=(2*i)+1;
                bucket=capacity-plants[i];

                
                
            }

            i++;

        }

        return steps;
        
    }
}