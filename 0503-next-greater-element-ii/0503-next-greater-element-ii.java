class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        while (i < 2 * n) {
            int currentIndex = i % n;

            while (!stack.isEmpty() && nums[currentIndex] > nums[stack.peek()]) {
                int pos = stack.pop();
                res[pos] = nums[currentIndex];
            }

            if (i < n) {
                stack.push(i);
            }
            i++;
        }

        return res;
    }
}