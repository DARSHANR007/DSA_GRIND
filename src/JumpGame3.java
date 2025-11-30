public class JumpGame3 {

    public boolean canReach(int[] arr, int start) {

        if(arr[start]==0) return true;

        boolean[] visited=new boolean[arr.length];

        return helper(arr,start+arr[start],visited);




    }


    public boolean helper(int[] arr, int index, boolean[] visited){


        int n=arr.length;

        if(index< 0|| index>=n ||visited[index]){
            return false;
        }

        if(arr[index]==0) return true;



        return helper(arr,index+arr[index],visited) || helper(arr,index-arr[index],visited);



    }
}
