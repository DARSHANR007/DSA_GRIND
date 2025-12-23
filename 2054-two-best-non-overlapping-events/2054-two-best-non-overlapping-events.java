class Solution {
   public int maxTwoEvents(int [][] events){

        int n=events.length;

        Arrays.sort(events,(a,b)->Integer.compare(a[1], b[1]));


        int[] maxsofar= new int[n];

        int[] end= new int[n];

        end[0]=events[0][1];

        maxsofar[0]=events[0][2];

        
        for(int i=1;i<n;i++){
            maxsofar[i]=Math.max(maxsofar[i-1],events[i][2]);
            end[i]=events[i][1];
        }

        int maxi=-1;

        for(int i=0;i<n;i++){
             int currStart = events[i][0];
            int currValue = events[i][2];


            int best= binarySearch(end, currStart);


            int currtotal= currValue;


            if(best !=-1){
                currtotal+=maxsofar[best];
            }

            maxi=Math.max(maxi,currtotal);
      }

        return maxi;
    }


    public int binarySearch(int[] end , int target){

        int low=0;

        int high=end.length-1;

        int res=-1;


        while (low <= high) {

            int mid=(high+low)/2;


            if(end[mid] <  target){

                res=mid;
                low=mid+1;


            } else{
                high=mid-1;
            }
            
        }

        return res;

    }
}