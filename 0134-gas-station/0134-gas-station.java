class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int capacity=0;

        int n=gas.length;

        int totalgas=0;

        int gasUsed=0;

        int start=0;


        for(int i=0;i<n;i++){

            capacity+=gas[i]-cost[i];

            totalgas+=gas[i];
            gasUsed+=cost[i];


            if(capacity < 0){
                capacity=0;
                start=i+1;
            }



        }


        if( gasUsed > totalgas) return -1;


        return start;
        
    }
}