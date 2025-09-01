public class vacation {


    public int helper1(int n, int arr1[], int arr2[], int arr3[]) {

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int[] dp3 = new int[n];




        dp1[0] = arr1[0];
        dp2[0] = arr2[0];
        dp3[0] = arr3[0];


        for (int i = 1; i < n; i++) {

            dp1[i] = arr1[i] + Math.max(dp2[i -1], dp2[i -1]);

            dp2[i] = arr2[i] + Math.max(dp1[i - 1], dp3[i-1]);

            dp3[i] = arr3[i] + Math.max(dp1[i - 1], dp2[i - 1]);

        }
        


        return Math.max(dp1[n - 1], Math.max(dp2[n - 2], dp3[n - 3]));

    }
    
}
