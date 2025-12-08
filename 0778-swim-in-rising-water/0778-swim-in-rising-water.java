class Solution {
   
     public int swimInWater(int[][] grid) {

        int time=0;

        int m=grid.length;
        
        int n=grid.length;

        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a ->a[0]));

        pq.add(new int[]{grid[0][0],0,0});

        boolean [][] visited=new boolean[m][n];

        visited[0][0]=true;


        int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};


        while (!pq.isEmpty()) {

            int []arr= pq.poll();

            int cur=arr[0];
            int x=arr[1];
            int y=arr[2];

            time=Math.max(time,cur);

            if ( x==m-1 && y==n-1) return time;

            for(int[] direction:directions){
                int nr =x+direction[0];
                int nc=y+ direction[1];

                if( nr >=0 && nr < m && nc >=0 && nc<n && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    pq.add(new int[]{grid[nr][nc],nr,nc});

                }

            }
            
        }



    


        return time;
        
    }
}