class Solution {
    public int[] dailyTemperatures(int[] temperatures) {



        Stack<Integer> stack= new Stack<>();




        int i=0;

        int n= temperatures.length;

        int [] res= new int[n];



        while(i < n){

            while( !stack.isEmpty() && temperatures[i] > temperatures[stack.peek()] ){

                int index=stack.pop();

                res[index]=i-index;


            }

            stack.push(i);
            i++;

        }


        return res;
        
    }
}