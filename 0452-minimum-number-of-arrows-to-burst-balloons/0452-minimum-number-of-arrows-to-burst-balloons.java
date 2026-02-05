class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));

        int n=points.length;


        int count=1;

        int prev=points[0][1];



        for(int i=1;i<n;i++){

            int[] curr=points[i];

        
            if(curr[0] > prev){
                count++;
                prev=curr[1];
        

        }
        }

        return count;
        
    }
}