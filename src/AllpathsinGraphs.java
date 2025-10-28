import java.util.ArrayList;
import java.util.List;

public class AllpathsinGraphs {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {



        return new ArrayList<>();

    }


    public void helper(List<List<Integer>> graph, int n,List<Integer> path, boolean[] visited, int index){


        if(path.get(path.size()-1)==n-1){
            graph.add(new ArrayList<>(path));
        }

        if(!visited[index]){
            helper(graph,n,path);
        }




    }
}
