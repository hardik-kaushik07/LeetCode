class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int row = 0, col = 0, emptyCell = 0;
        for(int i = 0; i < n; i++){
            for(int  j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    row = i;
                    col = j;
                }

                if(grid[i][j] == 0){
                    emptyCell ++;
                }
            }
        }
        return solve(grid, vis, row, col, emptyCell);
    }

    public int solve(int[][] grid, boolean[][] vis, int row, int  col, int emptyCell){

        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || vis[row][col] || grid[row][col] == -1){
            return 0;
        }

        if(grid[row][col] == 2){
            if(emptyCell == -1){
                return 1;
            }
            else{
                return 0;
            }
        }
        
        vis[row][col] = true;

        int right = solve(grid, vis, row, col+1, emptyCell-1);
        int down = solve(grid, vis, row+1, col, emptyCell-1);
        int left = solve(grid, vis, row, col-1, emptyCell-1);
        int up = solve(grid, vis, row-1, col, emptyCell-1);

        vis[row][col] = false;

        return right + down + left + up;
    }
}