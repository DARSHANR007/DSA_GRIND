import java.util.ArrayList;
import java.util.List;

public class cheapestFlight {


    private class flight{
        
        int node;
        int cost;

        flight(int destination, int cost){

            this.node=destination;
            this.cost=cost;
        }

    }

        List<List<flight>> res=new ArrayList<>();


     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {


        List<List<flight>> adj=new ArrayList<>();

        boolean[] visited=new boolean[n];

        
        for(int i=0;i<n;i++){

            adj.add(new ArrayList<>());

        }

        for(int [] x:flights){
            adj.get(x[0]).add(new flight(x[1], x[2]));

        }

        
        List<flight> path=new ArrayList<>();
        flight startFlight = new flight(src, 0);
        dfs(adj,src,dst,path,startFlight ,visited, k);


        int mini=Integer.MAX_VALUE;

        for(List<flight> optimals:res){

            int fare=0;


            for(flight x:optimals){
                fare+=x.cost;

            }
            mini=Math.min(fare, mini);
        }

        return mini;



        
    }


    public void dfs(List<List<flight>> graph,int src, int dst, List<flight> path, flight curr, boolean[] visited,int k){

        
        if(curr.node==dst && path.size()==k) res.add(path);

        visited[curr.node]=true;

        for(flight neighbour:graph.get(curr.node)){

            if(!visited[neighbour.node]){

                path.add(neighbour);
                dfs(graph, src, dst, path, neighbour, visited,k);
                path.remove(path.size()-1);


            }
        }

        visited[curr.node]=false;




    }


    
}
