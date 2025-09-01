public class lc741cherryPickup {


    int count=0;

    public int cherryPickup(int[][] grid) {
        int m=grid.length;

        int n=grid[0].length;


        int [][] paths=new int[m][n];
        int [][] paths2 =new int[m][n];


        boolean [][] dp=new boolean[m][n];


        topdown(grid, dp, paths);

        if(paths[m-1][n-1]==0){
            return 0;
        }


        bottomup(grid, dp, paths2);

        if(paths2[0][0]==0) return 0;


        return count;

        
    }


    public void topdown(int[][] grid, boolean[][] dp, int[][] paths){

        int m=grid.length;

        int n=grid[0].length;

        for(int i=0;i<n;i++){

            paths[0][i]=1;

            if(grid[0][i]==1){
                count++;
                dp[0][i]=true;
            }
            if(grid[0][i]==-1){
                break;
            }
        }

        for(int i=0; i<m;i++){

            paths[i][0]=1;

            if(grid[i][0]==1){
                count++;
                dp[i][0]=true;
            }
            if(grid[i][0]==-1){
                break;
            }

        }


        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j]==1){
                    paths[i][j]=paths[i-1][j]+paths[i][j-1];
                    dp[i][j]=true;
                    count++;
                }
            }
        }


    }


    public void bottomup(int[][] grid, boolean[][] dp, int[][] paths2){

        int m=grid.length;

        int n=grid[0].length;

        for(int i=n-1;i>=0;i--){

            paths2[0][i]=1;

            if(grid[0][i]==1  && !dp[0][i]){
                count++;
                dp[0][i]=true;
            }
            if(grid[0][i]==-1){
                break;
            }
        }

        for(int i=m-1; i>=0;i--){

            paths2[i][0]=1;

            if(grid[i][0]==1 && !dp[i][0]){
                count++;
                dp[i][0]=true;
            }
            if(grid[i][0]==-1){
                break;
            }

        }


        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(grid[i][j]==1 && !dp[i][j]){
                    paths2[i][j]=paths2[i+1][j]+paths2[i][j+1];
                    dp[i][j]=true;
                    count++;
                }
            }
        }


    }
    
}
