class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));


        List<int[]> list= new ArrayList();

        int n=intervals.length;

        int [] prev=intervals[0];

        for(int i=1;i<n;i++){


            int start=intervals[i][0];
            int end=intervals[i][1];

            if( start <= prev[1]){
                prev[1]=Math.max(end,prev[1]);
            }
            else{
                list.add(prev);
                prev=intervals[i];
            }
        
        }

            list.add(prev);

        return list.toArray(new int[list.size()][]);
        
    }
}