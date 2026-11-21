class Solution {
    class Pair implements Comparable<Pair>{
        int row, col, dis;
        public Pair(int row, int col, int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
        public int compareTo(Pair p){
            if(this.dis==p.dis) return  this.row-p.row;
            return this.dis-p.dis;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int[][] efforts = new int[heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }
        efforts[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0 ,0));
        while(pq.size()>0){
            Pair front = pq.poll();
            int row = front.row, col = front.col, dis = front.dis;
            
            if(row < efforts.length-1){
                int diff = Math.abs(heights[row+1][col] - heights[row][col]);
                int maxDiff = Math.max(dis, diff);
                if(efforts[row+1][col]> maxDiff){
                    efforts[row+1][col] = maxDiff;
                    pq.add(new Pair(row+1, col, maxDiff));
                }
            }
            if(row > 0){
                int diff = Math.abs(heights[row-1][col] - heights[row][col]);
                int maxDiff = Math.max(dis, diff);
                if(efforts[row-1][col]> maxDiff){
                    efforts[row-1][col] = maxDiff;
                    pq.add(new Pair(row-1, col, maxDiff));
                }
            }
            if(col > 0){
                int diff = Math.abs(heights[row][col-1] - heights[row][col]);
                int maxDiff = Math.max(dis, diff);
                if(efforts[row][col-1]> maxDiff){
                    efforts[row][col-1] = maxDiff;
                    pq.add(new Pair(row, col-1, maxDiff));
                }
            }
            if(col < efforts[0].length-1){
                int diff = Math.abs(heights[row][col+1] - heights[row][col]);
                int maxDiff = Math.max(dis, diff);
                if(efforts[row][col+1]> maxDiff){
                    efforts[row][col+1] = maxDiff;
                    pq.add(new Pair(row, col+1, maxDiff));
                }
            }
        }
        return efforts[efforts.length-1][efforts[0].length-1];
    }
}