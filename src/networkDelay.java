import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class networkDelay{ 



    class Network{
         int destination;
         int cost;

         Network( int destination, int cost){
            this.destination=destination;
            this.cost=cost;
         }

        
    
    }


     List<List<Network>> paths=new ArrayList<>();


     public int networkDelayTime(int[][] times, int n, int k) {

        // Initialize each node's list as null or empty list
        for (int i = 0; i <= n; i++) { // using <= n if nodes are 1-indexed
            paths.add(new ArrayList<>()); // initialize empty list for each node
        }

        // Add edges
        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int cost = time[2];

            paths.get(source).add(new Network( destination, cost));
        }

        return 0;
    }


    public int dijkstras(List<List<Network>> graph,int n, int start){


        int[] distances=new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[start]=0;

        PriorityQueue<Network> pq=new PriorityQueue<>(Comparator.comparing(a->a.cost));

        pq.add(graph.get(start));

        while (!pq.isEmpty()) {

            Network curr=pq.poll();
             int cost=curr.cost;
             int destination=curr.destination;

             if(cost > distances[destination])continue;


             for( Network neighbours: graph.get(curr.destination)){

                int newCost=neighbours.cost+cost;

                if( newCost < distances[destination]){
                    distances[destination]=newCost;
                    pq.add(new Network(neighbours.destination, newCost));
                }
                  
             }
            
        }

        int maxi=Integer.MIN_VALUE;
        for(int i:distances){
            maxi=Math.min(maxi,i);
        }




        return maxi;

    }







}