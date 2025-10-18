import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc2099 {

    HashMap<Integer,List<Integer>> hash = new HashMap<>();
    int maxi=Integer.MIN_VALUE;


    public int[] maxSubsequence(int[] nums, int k) {




       int[] res=hash.get(maxi).integerList.stream().maptoInt(Integer::intValue).toArray();


       return res;


    }


    public void helper(int[] nums, int k, int index, int sum, List<Integer> list){

        if(index>= nums.length) return;

        if(list.size()==k){
            if(!hash.containsKey(sum)){
                hash.put(sum,new ArrayList<>(list));
                maxi=Math.max(maxi, sum);
            }
            return;
        }


        helper(nums,k,index+1,sum+nums[index],list);

        helper(nums,k, index+1, sum,list);



    }


}
