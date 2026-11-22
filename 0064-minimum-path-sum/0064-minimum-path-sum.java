class Solution {
    int minSum;
    class Pair implements Comparable<Pair>{
        int row, col, sum;
        public Pair(int row, int col, int sum){
            this.row = row;
            this.col = col;
            this.sum = sum;
        }
        public int compareTo(Pair p){
            if(this.sum==p.sum) return  this.row-p.row;
            return this.sum-p.sum;
        }
    }
    public int minPathSum(int[][] grid) {
        int[][] efforts = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }
        efforts[0][0] = grid[0][0];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0 ,grid[0][0]));
        while(pq.size()>0){
            Pair front = pq.poll();
            int row = front.row, col = front.col, sum = front.sum;
            if(sum > efforts[row][col]){
                continue;
            }
            if(row < efforts.length-1){
                int total = sum + grid[row+1][col];
                if(efforts[row+1][col] > total){
                    efforts[row+1][col] = total;
                    pq.add(new Pair(row+1, col, total));
                }
            }
            // if(row > 0){
            //     int total = sum + grid[row-1][col];
            //     if(efforts[row-1][col]> total){
            //         efforts[row-1][col] = total;
            //         pq.add(new Pair(row-1, col, total));
            //     }
            // }
            // if(col > 0){
            //     int total = sum + grid[row][col-1];
            //     if(efforts[row][col-1]> total){
            //         efforts[row][col-1] = total;
            //         pq.add(new Pair(row, col-1, total));
            //     }
            // }
            if(col < efforts[0].length-1){
                int total = sum + grid[row][col+1];
                if(efforts[row][col+1]> total){
                    efforts[row][col+1] = total;
                    pq.add(new Pair(row, col+1, total));
                }
            }
        }
        return efforts[efforts.length-1][efforts[0].length-1];
    }
}