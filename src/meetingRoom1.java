import java.util.Arrays;
import java.util.Comparator;

public class meetingRoom1 {

    public boolean canAttendMeetings(int[][] intervals) {


        Arrays.sort(intervals, Comparator.comparingInt(A -> A[1]));

        int n=intervals.length;


        int [] previous= intervals[0];



        for(int i=1;i<n;i++){

            int [] current= intervals[i];

            if( current[0] < previous[1]){
                return false;
            }

            previous=current;

        }





        return true;

    }
}
