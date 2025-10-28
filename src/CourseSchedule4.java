import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule4 {


    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries){

        HashMap<Integer,List<Integer>> hash=new HashMap<>();
        for(int i=0;i<numCourses;i++){

            hash.put(i, new ArrayList<>());

        }


        for(int[] edge:prerequisites){

            int u=edge[0];
            int v=edge[1];

            hash.get(u).add(v);
        }


        boolean[][] canReach=new boolean[numCourses][numCourses];

        List<Boolean> result=new ArrayList<>();


        for(int i=0;i<numCourses;i++){
            dfs(hash,canReach,new boolean[numCourses],i,i);
        }


        for(int i=0;i< queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];


            result.add( canReach[u][v]);
        }

        return result;
    }

    public void dfs(HashMap<Integer,List<Integer>> hash,boolean[][] canReach, boolean[] visited, int start, int next){


        visited[next]=true;

        for(int neighbours:hash.get(next)){
            if(!visited[neighbours]){
                dfs(hash,canReach,visited,start,neighbours);
                canReach[start][neighbours]=true;
            }
        }

    }
}
