class Subset_Sum_NOADJ {
    





    public int dp_int(int n, int[] arr) {

        int[] dp = new int[n];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {

            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]); //or dp[i]=Math.max(dp[i-1],arr[i]+dp[i-1]-arr[i-1]);
        }

        return dp[n - 1];

    }
    
    public int space_optimized(int n, int[] arr) {

        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        int temp = 0;

        for (int i = 2; i < n; i++) {

            temp = curr;

            curr = Math.max(curr, prev + arr[i]);
            prev = temp;
        }

        return curr;
    }
    
    public int type_2(int n, int[] arr1, int[] arr2) {
        

        int[] dp = new int[n];


        dp[0] = Math.max(arr1[0], arr2[0]);

        dp[1] = Math.max(dp[0], Math.max(arr1[1], arr2[2]));
        
        for (int i = 2; i < n; i++) {
            
            dp[i] = Math.max(dp[i - 1], Math.max(arr1[i]+dp[i-2],arr2[i]+dp[i-2]));
        }

        return dp[n - 1];
    }
}