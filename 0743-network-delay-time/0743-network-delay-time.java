class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int time;
        public Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
         public int compareTo(Pair p){
            if(this.time == p.time) return this.node-p.node;
            return this.time-p.time;
         }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            int node = times[i][0], desti = times[i][1], time = times[i][2];
            adj.get(node).add(new Pair(desti, time));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k, 0));
        while(pq.size()>0){
            Pair front = pq.poll();
            int node = front.node, time = front.time;
            if(time > ans[node]){
                continue;
            }
            for(Pair p : adj.get(node)){
                int totalTime = time + p.time;
                if(totalTime<ans[p.node]){
                    ans[p.node] = totalTime;
                    pq.add(new Pair(p.node, totalTime));
                }
            }
        }
        int  maxTime = 0;
        for(int i = 1; i < ans.length; i++){
            if(ans[i]==Integer.MAX_VALUE) return -1;

            maxTime = Math.max(maxTime, ans[i]);
        }
        return maxTime;
    }
}