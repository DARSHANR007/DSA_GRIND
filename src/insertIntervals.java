    import java.util.ArrayList;
    import java.util.List;

    public class insertIntervals {

        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> res = new ArrayList<>();
            int n = intervals.length;
            int i = 0;

            int start = newInterval[0];
            int end   = newInterval[1];

            // If input might be unsorted by start, uncomment this:
            // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            // 1) add all intervals completely before newInterval
            while (i < n && intervals[i][1] < start) {
                res.add(intervals[i++]);
            }

            // 2) merge all that overlap with [start, end]
            while (i < n && intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end   = Math.max(end,   intervals[i][1]);
                i++;
            }
            res.add(new int[]{start, end});

            // 3) add the remaining intervals
            while (i < n) {
                res.add(intervals[i++]);
            }

            return res.toArray(new int[res.size()][]);
        }
    }
