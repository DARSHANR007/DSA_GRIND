import java.util.*;

class EventOrganizerCodeChef{

    static class Event {
        int start, end, comp;
        Event(int s, int e, int c) {
            this.start = s;
            this.end = e;
            this.comp = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt(); // number of test cases
        while (T-- > 0) {
            int N = sc.nextInt();
            Event[] events = new Event[N];

            for (int i = 0; i < N; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int c = sc.nextInt();
                events[i] = new Event(s, e, c);
            }

            System.out.println(maxCompensation(events, N));
        }
        
        sc.close();
    }

    // DP + Binary Search
    private static int maxCompensation(Event[] events, int n) {
        // Step 1: sort by end time
        Arrays.sort(events, (a, b) -> a.end - b.end);

        int[] dp = new int[n];
        dp[0] = events[0].comp;

        for (int i = 1; i < n; i++) {
            int include = events[i].comp;

            int prev = binarySearch(events, i);
            if (prev != -1) {
                include += dp[prev];
            }

            dp[i] = Math.max(dp[i - 1], include);
        }

        return dp[n - 1];
    }

    // Binary search: find last event ending before events[i].start
    private static int binarySearch(Event[] events, int i) {
        int low = 0, high = i - 1, ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (events[mid].end <= events[i].start) {
                ans = mid;
                low = mid + 1; // search further right
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
