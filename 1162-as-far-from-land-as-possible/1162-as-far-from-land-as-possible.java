class Solution {
    public int maxDistance(int[][] grid) {

        int maxi=-1;
        Queue<int[]> queue=new LinkedList();  //i,j,distance

        int m=grid.length;
        int n=grid[0].length;


        for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){

            if(grid[i][j]==1){
                queue.add(new int[]{i,j,0});
            }

         }
        }

        if(queue.size()==m*n || queue.isEmpty()) return -1;

        int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};

        while(!queue.isEmpty()){

            int[] curr=queue.poll();

            maxi=Math.max(curr[2],maxi);

            
            for(int [] dir:directions){
                int nr=dir[0]+curr[0];
                int nc=dir[1]+curr[1];


                if(nr>=0 && nr <m && nc >=0 && nc<n && grid[nr][nc]==0){

                    grid[nr][nc]=1;

                    queue.add(new int[]{nr,nc , curr[2]+1});


                }
            }



        }

        return maxi;
        
    }
}