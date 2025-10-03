public class 01Matrix {


    public int[][] updateMatrix(int[][] mat) {



        int m=mat.length;
        int n=mat[0].length;


        int [][] res=new int[m][n];


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    res[i][j]=0;
                }
                else{ /*bfs*/}
            }
        }


        
    }

    public void bfs(int [][] grid, int i, int j){

        int [] directions={{0,1},{1,0},{-1,0},{0,-1}};

        Queue<Integer> queue= new LinkedList();

        queue.offer()
        
    }
    
}
