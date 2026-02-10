class Solution {

        List<List<Integer>> list= new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        helper(candidates, target, 0,0,new ArrayList<>());

        return list;



        
    }


    public void helper(int[] nums, int target, int index, int sum, List<Integer> curr){{

        if(sum == target){
            list.add(new ArrayList<>(curr));
            return;
        }


        for(int i=index;i<nums.length;i++){

            if(sum+nums[i] <=target){

                curr.add(nums[i]);
                helper(nums,target,i,sum+nums[i],curr);
                curr.remove(curr.size()-1);
            }
        }




        
    }
    
    
    
    }
}