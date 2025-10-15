import java.util.LinkedList;
import java.util.Queue;

public class MapofHighestOrigin {

    public int[][] highestPeak(int[][] isWater) {

        Queue<int[]> queue=new LinkedList();

        int m= isWater.length;
        int n=isWater[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==0){
                    queue.add(new int[]{i,j});
                }

            }
        }

        int[][] directions={{1,0},{0,1},{-1,0},{0,-1}};

        while(!queue.isEmpty()){

            int[] curr=queue.poll();

            int row=curr[0];
            int col=curr[1];

            for(int [] direction:directions){
                int nr=row+direction[0];
                int nc=col+direction[1];

                if(nr>=0 && nr < m && nc>=0 && nc < n){

                    isWater[nr][nc]=1+isWater[row][col];
                    queue.add(new int[]{nr,nc});

                }
            }
        }



        return  isWater;

    }
}
