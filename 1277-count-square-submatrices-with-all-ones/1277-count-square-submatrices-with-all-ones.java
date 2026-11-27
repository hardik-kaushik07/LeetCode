class Solution {
    int count = 0;
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                solve(i, j, matrix, dp);
            }
        }
        return count;
    }
    public int solve(int row, int col, int[][] matrix, int[][] dp){
        if(row >= matrix.length || col >= matrix[0].length) return 0;
        if(matrix[row][col] == 0) return 0;

        if(dp[row][col] != 0)
            return dp[row][col];
            
        int right = solve(row, col+1, matrix, dp);
        int down = solve(row+1, col, matrix, dp);
        int diagonal = solve(row+1, col+1, matrix, dp);

        dp[row][col] = 1 + Math.min(right, Math.min(down, diagonal));
        count += dp[row][col];
        return dp[row][col];
    }
}