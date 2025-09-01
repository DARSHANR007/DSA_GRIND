import java.util.Arrays;

public class weightedDays {

    class Project {
        int start;
        int end;
        int profit;

        Project(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int solution(int[] start, int[] end, int[] profit, int n) {

        int[] dp = new int[n + 1];

        Project[] arr = inorder(start, end, profit);

        dp[1] = arr[0].profit;

        for (int i = 1; i < n; i++) {

            if (arr[i].start > arr[i - 1].end) {
                dp[i + 1] = arr[i].profit + dp[i];
            }
            if (arr[i].start <= arr[i - 1].end) {
                dp[i + 1] = Math.max(dp[i], arr[i].profit);
            }
        }

        return dp[n];
    }
    

    public int binary(Project[] arr, int index) {
        


        int start = 0;
        int end = arr.length - 1;
        int res = -1;


        while (start <= end) {

            int mid = start + end / 2;

            if (arr[mid].end < arr[index].start) {
                res = arr[mid].end;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        
        return res;
        




    }

    public Project[] inorder(int[] start, int[] end, int[] profit) {
        Project[] sorted = new Project[start.length];
        for (int i = 0; i < start.length; i++) {
            sorted[i] = new Project(start[i], end[i], profit[i]);
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(b.start, a.start));
        return sorted;
    }

    
}
