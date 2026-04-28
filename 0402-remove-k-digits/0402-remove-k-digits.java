class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();

        for (char x : num.toCharArray()) {
            int curr = x - '0';

            // pop when current digit is smaller than top
            while (!stack.isEmpty() && curr < stack.peek() && k > 0) {
                stack.pop();
                k--;  // charge one deletion
            }

            stack.push(curr);  // always push current digit
        }

        // k still remaining → delete from end (number is increasing)
        while (k > 0) {
            stack.pop();
            k--;
        }

        // build result
        StringBuilder res = new StringBuilder();
        for (int i : stack) {
            res.append(i);
        }

        // strip leading zeros
        int start = 0;
        while (start < res.length() - 1 && res.charAt(start) == '0') {
            start++;
        }

        return res.substring(start).isEmpty() ? "0" : res.substring(start);
    }
}