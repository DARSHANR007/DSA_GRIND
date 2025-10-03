public class 01Matrix {


    public int[][] updateMatrix(int[][] mat) {



        int m=mat.length;
        int n=mat[0].length;


        int [][] res=new int[m][n];

        boolean [][] visited=new boolean[m][n];



        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    res[i][j]=0;
                    queue.offer(new int[]{i,j});
                    
                }
                else{ res[i][j]=-1;}
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};


        while(!queue.isEmpty()){


            int [] curr=queue.poll();

            int x=curr[0];
            int y=curr[1];


            for(int [] direction=directions){

                int nr=direction[0]+x;
                int nc=direction[1]+y;


                if(nr>=0 && nr< rows && nc>=0 && nc< cols && res[nr][nc]=-1){

                    res[nr][nc]=res[x][y]+1;
                    queue.offer(new int[]{nr, nc});

                    
                }
            }

        }

        return res;
        
    }

    
    
}
