import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class BusRoutes {




    

    public int numBusesToDestination(int[][] routes, int source, int target) {

int n = routes.length;

        List<List<Integer>> path = new ArrayList<>();

        Set<Integer> hash=new HashSet<>();

        for (int i = 0; i < n; i++) {
            path.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                path.get(i).add(stop);
                hash.add(stop);
            }
        }

        int count=0;

        boolean [] visited=new boolean[hash.size()];
 
        Queue<Integer> queue =new LinkedList<>();

        queue.add(source);
        aaaaaN
        Queue<Integer> visited=new Queue<LinkedList

        




        while (!queue.isEmpty()) {

            
            

            int curr=queue.poll();
            visited[curr]=true;

            for( int stop: path.get(curr)){

                if(visited[stop] && curr )

                queue.add(stop);
                if(stop==target){
                    return count;
                }
            }
            count++;

        }

        return 0;
    }

}
