class Solution {
    class pair{
        int row, col, distance;
        public pair(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance  = distance;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] dis = new int[mat.length][mat[0].length];

        Queue<pair> q = new LinkedList<>();

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j]==0){
                    q.add(new pair(i, j, 0));
                    dis[i][j] = 0;
                }
                else{
                    dis[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            pair front = q.poll();
            int row = front.row;
            int col = front.col;
            int distance = front.distance;
            if(row > 0 && mat[row-1][col]==1 && dis[row-1][col]==-1){
                dis[row-1][col] = distance+1;
                q.add(new pair(row-1, col, distance+1));
                
            }
            if(row < mat.length-1 && mat[row+1][col]==1 && dis[row+1][col]==-1){
                dis[row+1][col] = distance+1;
                q.add(new pair(row+1, col, distance+1));
                
            }
            if(col > 0 && mat[row][col-1]==1 && dis[row][col-1]==-1){
                dis[row][col-1] = distance+1;
                q.add(new pair(row, col-1, distance+1));
                
            }
            if(col < mat[0].length-1 && mat[row][col+1]==1 && dis[row][col+1]==-1){
                dis[row][col+1] = distance+1;
                q.add(new pair(row, col+1, distance+1));
                
            }
        }
        return dis;
    }
}