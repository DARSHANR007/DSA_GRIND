import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {



        int m=image.length;
        int n=image[0].length;


        Queue<int[]> queue= new LinkedList<>();

        queue.add(new int[]{sr,sc});

        int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};

        while(!queue.isEmpty()){

            int[] curr=queue.poll();

            int row=curr[0];
            int col=curr[1];

            for(int[] direction:directions){

                int nr=row+direction[0];
                int nc=col+direction[1];

                if(nr >=0 && nr <m && nc>=0 && nc < n ){

                    if( image[nr][nc]!=color){
                        image[nr][nc]=color;
                        queue.add(new int[]{nr,nc});
                    }
                }
            }
        }


        return image;

    }
}
