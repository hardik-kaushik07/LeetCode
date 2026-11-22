class Solution {
    class Triplet{
        int node, cost, stops;
        public Triplet(int node, int cost, int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    class Pair{
        int node, cost;
        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        Queue<Triplet> q = new LinkedList<>();

        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < flights.length; i++){
            int node  = flights[i][0], dest = flights[i][1], cost = flights[i][2];

            adj.get(node).add(new Pair(dest, cost));
        }

        q.add(new Triplet(src, 0, 0));

        while(q.size()>0){
            Triplet front = q.poll();
            if(front.stops == k+1) continue;

            for(Pair p : adj.get(front.node)){
                int totalCost = front.cost + p.cost;
                if(totalCost < ans[p.node]){
                    ans[p.node] = totalCost;
                    q.add(new Triplet(p.node, totalCost, front.stops + 1));
                }
            }
        }
            if(ans[dst]== Integer.MAX_VALUE){
                return -1;
            }
        return ans[dst];
    }
}