import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Gatherer.Integrator;

public class safestpathGrpah {


    public int maximumSafenessFactor(List<List<Integer>> grid) {

         int rows = grid.size();
        int cols = grid.get(0).size(); 

        int[][] arr = new int[rows][cols];

        Queue<int[]> queue=new LinkedList<>();

        int[][] safe=new int[rows][cols];

            for( int [] x:arr){

                Arrays.fill(x, -1);
            }
        

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = grid.get(i).get(j);
                if (arr[i][j] == 1) {

                    queue.offer(new int[]{i,j});
                    safe[i][j]=0;

                }
            }
        }

            int[][] directions={{0,+1},{+1,0},{-1,0},{0,-1}};


        while (!queue.isEmpty()) {

            int[] curr=queue.poll();

            int c=curr[0];
            int d=curr[1];




            for(int [] direction:directions){

                int x=direction[0];
                int y=direction[1];

                int nr=x+c;
                int nc=y+d;

                while ( nr >=0 && nr < rows && nc >=0 && nc < cols ) {

                    safe[nr][nc]=Math.max(safe[nr][nc], safe[nr]);
                    
                }
            }
            
        }


        
        
    }
 
}
