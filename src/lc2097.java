import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc2097 {


    public int[][] validArrangement(int[][] pairs) {


        int n= pairs.length;

        boolean[][] canReach= new boolean[n][n];

        HashMap<Integer, List<Integer>> hash=new HashMap<>();

        for(int i=0;i<n;i++){

            hash.put(i,new ArrayList<>());

        }

        int[] indegree=new int[n];

        for(int[] pair:pairs){
            int u=pair[0];
            int v=pair[1];

            indegree[v]++;


            hash.get(u).add(v);
        }

        int start=0;

        for(int i=0;i<n;i++){

            if(indegree[i]==0){
                start=i;
            }
            break;

        }
        dfs(canReach,start,start,new boolean[n],hash);

        for(int i=0;i<n;i++){
            for(int j=start;j<n;j++){

            }
        }







        return new int[][]{};

    }


    public void dfs(boolean[][] canReach,int start, int next, boolean[] visited,  HashMap<Integer, List<Integer>> hash){

        visited[next]=true;


        for(int neighbour:hash.get(next)){
            if(!visited[neighbour]){
                dfs(canReach,start,neighbour,visited,hash);
                canReach[start][neighbour]=true;
            }
        }
    }


}
