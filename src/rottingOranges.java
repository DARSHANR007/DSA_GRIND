import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class rottingOranges {

    public int orangesRotting(int[][] grid) {


        int count=0;

        int time=0;

        int rottenCount=0;

        int rows=grid.length;
        int cols=grid[0].length;

        int[][] check=new int[rows][cols];


        Queue<int[]> queue=new LinkedList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if( grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                    check[i][j]=1;
                    count++;
                }
            }
        }


        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()){

            int[] curr=queue.poll();
            time++;

            int x=curr[0];
            int y=curr[1];

            for(int[] dir:dirs){
                int nr=dir[0]+x;
                int nc=dir[1]+y;

                if(nr>=0 && nr< rows && nc>=0 && nc< cols){

                    if(check[nr][nc]==1)continue;
                    if(grid[nr][nc]==2){
                        rottenCount++;
                    }
                    queue.offer(new int[]{nr,nc});
                    check[nr][nc]=1;

                }
            }


        }

        return (count == rottenCount) ? time : -1;





    }
}
