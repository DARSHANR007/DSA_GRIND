import java.util.ArrayList;
import java.util.List;

public class lc1557 {


    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {


        int [] indegree=new int[n];

        int[] outdegree=new int[n];

        List<Integer> res=new ArrayList<>();

    
        for(int i=0;i<n;i++){

            int sending=edges.get(i).get(0);
            int recieving=edges.get(i).get(1);


            outdegree[sending]++;
            indegree[recieving]++;

        }

        for(int i=0;i<n;i++){

            if(indegree[i]==0){
                res.add(i);

            }

        }


        return res;




    }


}
