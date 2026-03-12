class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n= nums1.length;

        HashMap<Integer,Integer> hash= new HashMap();
        
        Stack<Integer> stack= new Stack<>();


        for(int num:nums2){

            while(!stack.isEmpty() && num > stack.peek()){

                hash.put(stack.pop(),num);
            }

            stack.push(num);
        }

        int[] res= new int[n];


        for(int i=0;i<nums1.length;i++){

            res[i]=hash.getOrDefault(nums1[i],-1);

        }

        return res;
        
    }
}