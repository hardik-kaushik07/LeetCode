class Solution {
    class pair{
        int row, col, time;
        public pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int minTime = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]==2){
                    q.add(new pair(i, j, 0));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        while(q.size()>0){
            pair front = q.poll();
            int row = front.row;
            int col = front.col;
            int time = front.time;
            visited[row][col] = true;
            minTime = Math.max(minTime, time);
            if(row>0 && grid[row-1][col] == 1 && !visited[row-1][col]){
                q.add(new pair(row-1, col, time+1));
                grid[row-1][col] = 2;
                visited[row-1][col] = true;
                fresh--;
            }
            if(row < grid.length-1 && grid[row+1][col] == 1 && !visited[row+1][col]){
                q.add(new pair(row+1, col, time+1));
                grid[row+1][col] = 2;
                visited[row+1][col] = true;
                fresh--;
            }
            if(col>0 && grid[row][col-1] == 1 && !visited[row][col-1]){
                q.add(new pair(row, col-1, time+1));
                grid[row][col-1] = 2;
                visited[row][col-1] = true;
                fresh--;
            }
            if(col < grid[0].length-1 && grid[row][col+1] == 1 && !visited[row][col+1]){
                q.add(new pair(row, col+1, time+1));
                grid[row][col+1] = 2;
                visited[row][col+1] = true;
                fresh--;
            }
        }
        if(fresh > 0){
            return -1;
        }
        return minTime;
    }
}