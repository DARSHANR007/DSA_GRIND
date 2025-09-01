import java.util.Arrays;

public class DiceCombo {

    public int diceCombinations(int n) {




        int[][] memo = new int[n + 1][7];

        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return helper(n, 0, 1,memo); // Start from face = 1
    }

    public int helper(int target, int sum, int index, int[][] memo) {

        if (sum == target)
            return 1;

        if (sum > target || index > 6)
            return 0;

        if (memo[sum][index] != -1)
            return memo[sum][index];
        

        int pick = helper(target, sum + index, index,memo); // Pick: stay on same face

        // Don’t pick: move to next face
        int dont_pick = helper(target, sum, index + 1,memo);

        memo[sum][index] = pick + dont_pick;
        
        return memo[sum][index];
    }

     
}
