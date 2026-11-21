class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]!=0){
                   int currGold = dfs(i, j, grid, vis, 0, 0);
                   maxGold = Math.max(maxGold, currGold);
                }
            }
        }
        return maxGold;
    }
    public int dfs(int row, int col, int[][] grid, boolean[][] vis, int curr, int maxGold){
        if(row < 0 || row >= grid.length ||
           col < 0 || col >= grid[0].length ||
           vis[row][col] || grid[row][col] == 0){
            return 0;
        }
        vis[row][col] = true;
        curr += grid[row][col];
        maxGold = Math.max(maxGold, curr);
        int up = dfs(row-1, col, grid, vis, curr, maxGold);
        int left = dfs(row, col-1, grid, vis, curr, maxGold);
        int down = dfs(row+1, col, grid, vis, curr, maxGold);
        int right = dfs(row, col+1, grid, vis, curr, maxGold);

        if(maxGold < up){
            maxGold = up;
        }
        if(maxGold < left){
            maxGold = left;
        }
        if(maxGold < down){
            maxGold = down;
        }
        if(maxGold < right){
            maxGold = right;
        }
        vis[row][col] = false;

        return  Math.max(maxGold, curr);
    }
}