class Solution {
    // Normal Recursion: 
    // public int uniquePaths(int m, int n) {
        
    //     return helper(0, 0, m, n);
    // }

    // public int helper(int row, int col, Integer m, Integer n){
    //     if(row >= m || col >= n) return 0;
    //     if(row == m-1 && col == n-1) return 1;
    //     int right = helper(row, col+1, m, n);
    //     int down = helper(row+1, col, m, n);
    //     return right + down;
    // }

    // Using Memoization:

    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    //     for(int i = 0; i < m; i++){
    //         for(int j = 0; j < n; j++){
    //             dp[i][j] = -1;
    //         }
    //     }
    //     return helper(0, 0, m, n, dp);
    // }
    // public int helper(int row, int col, Integer m, Integer n, int[][] dp){
    //     if(row >= m || col >= n) return 0;
    //     if(row == m-1 && col == n-1) return 1;
    //     if(dp[row][col]!=-1) return dp[row][col];
    //     int right = helper(row, col+1, m, n, dp);
    //     int down = helper(row+1, col, m, n, dp);
    //     // return dp[row][col] = helper(row, col+1, m, n, dp) + helper(row+1, col, m, n, dp);

    //     return dp[row][col] = right + down;
    // }

    // Using Tabulation:
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i==0 || j==0) dp[i][j] = 1;
                else dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}