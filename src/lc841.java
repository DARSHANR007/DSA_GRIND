import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class lc841 {

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {


            int n=rooms.size();

            int[] indegree=new int[n];

            indegree[0]=0;

            int count=0;


            Queue<List<Integer>> kahn = new LinkedList<>();


            kahn.add(rooms.get(0));


            while (!kahn.isEmpty()) {

                List<Integer> current=kahn.poll();
                count++;


                for( int v : current){

                    indegree[v]--;

                    if(indegree[v]==0){

                        kahn.add(rooms.get(v));
                    }
                    

                }


                
            }


            return count==n;
        
    }
    
}
