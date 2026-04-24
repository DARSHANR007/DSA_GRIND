class Solution {

    public boolean isValid(String s) {
        char[] arr = s.toCharArray();

        Stack<Character> stack = new Stack();

        for (char x : arr) {
            if (x == ']' || x == '}' || x == ')') {
                char curr = x;

                if (!stack.isEmpty() && (x == ']' && stack.peek() == '[' || x == ')' && stack.peek() == '(' || x == '}' && stack.peek() == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(x);
            }
        }

        return stack.isEmpty();
    }
}
