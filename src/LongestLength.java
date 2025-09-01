import java.util.ArrayList;
import java.util.List;

public class LongestLength {


    List<List<Integer>> list;

    int[] dp;


    public void adjList(int[][] graph) {

        for (int[] arr : graph) {
            int source = arr[0];
            int destination = arr[1];

            list.get(source).add(destination);
        }
    }

    public void dfs(List<List<Integer>> list,int node,boolean[] visited) {
        
        visited[node] = true;

        for (int neighbours : list.get(node)) {
            
            if (!visited[neighbours]) {
                dfs(list, node,visited);
            }
        }
        
    }
    





  










    
}
