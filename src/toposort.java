import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class toposort {



     int n;
     List<List<Integer>> graph;
    
     int[] toComplete;

    public toposort(int size) {
        this.n = size;
        graph = new ArrayList<>();
        toComplete = new int[n];


        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
    }
    
    public void addEdges(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {

            int source = arr[i][0];
            int destination = arr[i][1];

            toComplete[destination]++;

            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }

    }
    
    public void sorting() {

        int start=0;

        for(int i=0;i<toComplete.length;i++){

            if(toComplete[i]==0){
                start=i;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);


        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int neighbours : graph.get(node)) {
                
                --toComplete[neighbours];

                if (toComplete[neighbours] == 0) {
                    queue.add(neighbours);
                }


            }
            
        }

        
    }
    
    
}
