public class Goldmansachs2023OA {

    public int dp_solution(int[] arr, int n) {
        if (n <= 1) return 0;
        if (n == 2) return arr[1];
        
        boolean[] visited = new boolean[n];
        int totalCost = arr[1]; // Start at index 1
        visited[1] = true;
        int currentPos = 1;
        
        while (currentPos < n - 1) {
            int nextPos = -1;
            int minCost = Integer.MAX_VALUE;
            
            // Option 1: Move 2 steps forward
            if (currentPos + 2 < n && !visited[currentPos + 2]) {
                if (arr[currentPos + 2] < minCost) {
                    minCost = arr[currentPos + 2];
                    nextPos = currentPos + 2;
                }
            }
            
            // Option 2: Move 1 step backward (if valid and not visited)
            if (currentPos - 1 >= 0 && !visited[currentPos - 1]) {
                if (arr[currentPos - 1] < minCost) {
                    minCost = arr[currentPos - 1];
                    nextPos = currentPos - 1;
                }
            }
            
            if (nextPos == -1) {
                // Check if we can reach the end directly
                if (currentPos + 2 >= n) {
                    break; // We've crossed the array
                } else {
                    // No valid moves, we're stuck
                    return -1;
                }
            }
            
            // Move to the next position
            currentPos = nextPos;
            visited[currentPos] = true;
            totalCost += minCost;
        }
        
        return totalCost;
    }
    
    // Alternative recursive approach with memoization
    public int minCostToCross(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        if (n == 2) return arr[1];
        
        boolean[] visited = new boolean[n];
        visited[1] = true;
        
        return arr[1] + solve(arr, 1, visited, n);
    }
    
    private int solve(int[] arr, int pos, boolean[] visited, int n) {
        // If we've crossed the array
        if (pos >= n - 1) return 0;
        
        int minCost = Integer.MAX_VALUE;
        
        // Move 2 steps forward
        if (pos + 2 < n && !visited[pos + 2]) {
            visited[pos + 2] = true;
            int cost = arr[pos + 2] + solve(arr, pos + 2, visited, n);
            minCost = Math.min(minCost, cost);
            visited[pos + 2] = false; // backtrack
        }
        
        // Move 1 step backward
        if (pos - 1 >= 0 && !visited[pos - 1]) {
            visited[pos - 1] = true;
            int cost = arr[pos - 1] + solve(arr, pos - 1, visited, n);
            minCost = Math.min(minCost, cost);
            visited[pos - 1] = false; // backtrack
        }
        
        // If we can reach the end with a 2-step jump
        if (pos + 2 >= n) {
            minCost = Math.min(minCost, 0);
        }
        
        return minCost == Integer.MAX_VALUE ? Integer.MAX_VALUE : minCost;
    }
    
    // Test method
    public static void main(String[] args) {
        Goldmansachs2023OA solution = new Goldmansachs2023OA();
        int[] arr = {2, 5, 8}; // Example from the problem
        
        System.out.println("Minimum cost (greedy): " + solution.dp_solution(arr, arr.length));
        System.out.println("Minimum cost (recursive): " + solution.minCostToCross(arr));
    }




    
}
