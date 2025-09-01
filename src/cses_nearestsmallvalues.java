import java.util.Stack;

public class cses_nearestsmallvalues {

    public static int[] nearest_smallest_values(int n, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        res[0] = 0;
        stack.push(0);

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() + 1;
            }

            stack.push(i);
        }

        return res;
    }
}
