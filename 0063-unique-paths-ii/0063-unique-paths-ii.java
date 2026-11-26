class Solution {
    // Normal Recursion:
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     return helper(obstacleGrid, 0, 0, obstacleGrid.length, obstacleGrid[0].length);
    // }
    // public int helper(int[][] obsGrid, int row, int col, Integer m, Integer n){
    //     if(row>= m || col >= n || obsGrid[row][col] == 1) return 0;
    //     if(row == m-1 && col == n-1) return 1;
    //     int right = helper(obsGrid, row, col+1, m, n);
    //     int down = helper(obsGrid, row+1, col, m, n);
    //     return right + down;
    // }

    // Using Memoization:

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return helper(obstacleGrid, 0, 0, obstacleGrid.length, obstacleGrid[0].length, dp);
    }
    public int helper(int[][] obsGrid, int row, int col, Integer m, Integer n, int[][] dp){
        if(row>= m || col >= n || obsGrid[row][col] == 1) return 0;
        if(row == m-1 && col == n-1) return 1;
        if(dp[row][col] != -1) return dp[row][col];
        int right = helper(obsGrid, row, col+1, m, n, dp);
        int down = helper(obsGrid, row+1, col, m, n, dp);
        return dp[row][col] = right + down;
    }
}