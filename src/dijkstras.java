import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class dijkstras {

 static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    List<List<int[]>> adj =new ArrayList();
    int n;


    dijkstras(int n){
      this.n=n;

      for(int i=0;i<n;i++){

        adj.add(new ArrayList<>());
        
      }
    }

    public void createGraph( int[][] paths){   // [start, destination. weight]

        for(int[] path:paths){

            int source=path[0];
            int destination=path[1];
            int weight=path[2];

            adj.get(source).add(new int[]{destination,weight});
        }
        
        
    }

    public int[] dijkstras_Algo(int start, List<List<Pair>> graph){


     

        PriorityQueue<Pair> pq=new PriorityQueue<>( Comparator.comparing(a-> a.weight));

        int[] distances=new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start]=0;


        pq.add( new Pair(0, 0));


        while (!pq.isEmpty()) {

            Pair curr=pq.poll();

            int weight=curr.weight;
            int destination=curr.node;

            if(weight > distances[destination]){
                continue;
            }

            for(Pair neighbours: graph.get(destination)){

                int newDist=weight+neighbours.weight;

                if(newDist < distances[neighbours.node]){

                    distances[neighbours.node]=newDist;
                    pq.add(new Pair(neighbours.node, newDist));
                }
            }
            
        }
           
        return new int[]{};
    }
    
}
