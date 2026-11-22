class Solution {
    class Pair implements Comparable<Pair>{
        int node, dis;
        Pair(int node, int dis){
            this.node = node;
            this.dis = dis;
        }
        public int compareTo(Pair p){
            if(this.dis == p.dis) return this.node-p.node;
            return Integer.compare(this.dis, p.dis);
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int sum = 0;
        boolean[] vis = new boolean[points.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair front = pq.poll();
            int node = front.node, dis = front.dis;
            if(vis[node]) continue;
            vis[node] = true;
            sum += dis;
            for(int i = 0; i < points.length; i++){
                if(i==node) continue;
                if(vis[i]==true) continue;
                int x1 = points[node][0], x2 = points[i][0],
            y1 = points[node][1], y2 = points[i][1];

            int newDiff = Math.abs(x1-x2) + Math.abs(y1-y2);
            pq.add(new Pair(i, newDiff));
            }
        }
            return sum;
    }
}