import java.util.Arrays;
import java.util.PriorityQueue;

public class meetingrooms2 {


    public int emptyRooms(int[][] intervals){


        int n= intervals.length;


        Arrays.sort(intervals,(A,B)->Integer.compare(A[1],B[1]));

        int rooms=1;


        int[] prev=intervals[0];

        for(int i=1;i<n;i++){

            int[] current=intervals[i];

            if(current[0] < prev[1]){
                rooms++;
            }

            prev=current;

        }


        return rooms;
    }

    public int meeting2(int[][] intervals){

        int n= intervals.length;


        Arrays.sort(intervals,(A,B)->Integer.compare(A[0],B[0]));

        PriorityQueue<Integer> pq=new PriorityQueue<>();


        for(int[] time:intervals){

            if(!pq.isEmpty() && pq.peek() <= time[0]){
                pq.poll();
            }

            pq.offer( time[1]);
        }





        return pq.size();

    }



}
