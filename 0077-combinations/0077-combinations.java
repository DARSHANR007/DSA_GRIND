class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> list= new ArrayList<>();

        helper(n,k,new ArrayList<>(),1,list);


        return list;
        
    }



    public void helper(int n, int k, List<Integer> curr, int index,List<List<Integer>> list){


        if(curr.size()==k){
            list.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index;i<=n;i++){
            curr.add(i);

            helper(n,k,curr, i+1,list);

            curr.remove(curr.size()-1);
        }
    }
}