import java.util.ArrayList;
import java.util.List;

public class checkifpathexists {


    public boolean validPath(int n, int[][] edges, int source, int destination) {


        List<List<Integer>> list=new ArrayList();

        for(int i=0;i<n;i++){

            list.add(new ArrayList<>());

        }

        for(int [] edge:edges){
            int u=edge[0];
            int v=edge[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean[] visited=new boolean[n];

        dfs(list,visited,source);




        return visited[destination];

    }

    public  void dfs(List<List<Integer>> list, boolean [] visited,int node){

        visited[node]=true;

        for(int neighbour:list.get(node)){
            if(!visited[neighbour]){
                dfs(list,visited,neighbour);
            }
        }
    }
}
