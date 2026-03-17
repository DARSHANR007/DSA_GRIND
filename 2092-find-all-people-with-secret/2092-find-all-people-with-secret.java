class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] m : meetings) {
            adj.get(m[0]).add(new int[]{m[1], m[2]});
            adj.get(m[1]).add(new int[]{m[0], m[2]});
        }

        int[] earliestTime = new int[n];
        Arrays.fill(earliestTime, Integer.MAX_VALUE);
        
        earliestTime[0] = 0;
        earliestTime[firstPerson] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{0, 0});
        pq.add(new int[]{firstPerson, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int person = curr[0];
            int time = curr[1];

            if (time > earliestTime[person]) continue;

            for (int[] next : adj.get(person)) {
                int neighbor = next[0];
                int meetingTime = next[1];

                if (meetingTime >= time && earliestTime[neighbor] > meetingTime) {
                    earliestTime[neighbor] = meetingTime;
                    pq.add(new int[]{neighbor, meetingTime});
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earliestTime[i] != Integer.MAX_VALUE) {
                result.add(i);
            }
        }
        return result;
    }
}