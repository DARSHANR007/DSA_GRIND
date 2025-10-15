import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PacificAtlantic {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m; int n;

    void solve(int i, int j, int[][] heights, int prev, boolean[][] visited){

        if(i < 0 || i >= m || j < 0 || j >= n || prev > heights[i][j] || visited[i][j]){
            return;
        }

        visited[i][j] = true;

        for(int[] d : dir){
            int ni = i + d[0];
            int nj = j + d[1];

            solve(ni, nj, heights, heights[i][j], visited);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        for(int j = 0; j < n; j++){
            solve(0, j, heights, Integer.MIN_VALUE, pacificVisited);
            solve(m-1, j, heights, Integer.MIN_VALUE, atlanticVisited);
        }

        for(int i = 0; i < m; i++){
            solve(i, 0, heights, Integer.MIN_VALUE, pacificVisited);
            solve(i, n-1, heights, Integer.MIN_VALUE, atlanticVisited);
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(pacificVisited[r][c] && atlanticVisited[r][c]){
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }
}