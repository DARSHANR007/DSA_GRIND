public class minimumSteps {

    int mini = Integer.MAX_VALUE;

    public int mini_steps(int n) {


        String str = Integer.toString(n);

        int[] digits = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {

            digits[i] = str.charAt(i) - '0';
        }


       

    


    





        return 0;
    }


   public void helper(int[] digits, int n, int sum_up, int index, int steps, int[][] memo) {
    if (sum_up > n || index >= digits.length) return;

    if (sum_up == n) {
        memo[index][sum_up] = Math.min(mini, steps);
        return;
    }
    if (memo[index][sum_up] != -1)
         memo[index][sum_up];

    helper(digits, n, sum_up + digits[index], index, steps + 1,memo);
    
    helper(digits, n, sum_up, index + 1, steps,memo);
}


    public int dp_method(int n) {


         int temp = n;

         while (temp > 0) {

             int curr = temp % 10;
             temp /= n;

             mini = Math.min(mini, 1 + dp_method(n - curr));

         }
        
         return mini;

    



}

    
}
