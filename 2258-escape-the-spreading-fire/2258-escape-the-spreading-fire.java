class Solution {
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

    public int maximumMinutes(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        Queue<int[]> msbfs = new LinkedList<>();
        int[][] fire = new int[m][n];

        for (int[] arr : fire) Arrays.fill(arr, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    msbfs.add(new int[]{i,j,0});
                    fire[i][j] = 0;
                }
            }
        }

        while (!msbfs.isEmpty()) {
            int[] cur = msbfs.poll();

            for (int[] d : directions) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                int nt = cur[2] + 1;

                if (nr>=0 && nr<m && nc>=0 && nc<n) {
                    if (grid[nr][nc] != 2 && fire[nr][nc] == -1) {
                        fire[nr][nc] = nt;
                        msbfs.add(new int[]{nr,nc,nt});
                    }
                }
            }
        }

        int low = 0, high = 1_000_000_000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEscape(grid, fire, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    boolean canEscape(int[][] grid, int[][] fire, int wait) {

        int m = grid.length, n = grid[0].length;

        if (fire[0][0] != -1 && wait >= fire[0][0]) return false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        q.add(new int[]{0,0,wait});
        vis[0][0] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0], c = cur[1], t = cur[2];

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];
                int nt = t + 1;

                if (nr<0 || nr>=m || nc<0 || nc>=n) continue;
                if (grid[nr][nc] == 2 || vis[nr][nc]) continue;

                if (nr == m-1 && nc == n-1) {
                    if (fire[nr][nc] == -1 || nt <= fire[nr][nc])
                        return true;
                    continue;
                }

                if (fire[nr][nc] != -1 && nt >= fire[nr][nc]) continue;

                vis[nr][nc] = true;
                q.add(new int[]{nr,nc,nt});
            }
        }

        return false;
    }
}