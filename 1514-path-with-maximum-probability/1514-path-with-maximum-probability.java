class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        double prob;
        public Pair(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
         public int compareTo(Pair p){
            if(this.prob == p.prob) return this.node-p.node;
            return Double.compare(p.prob, this.prob);
         }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] ans = new double[n];
        Arrays.fill(ans, 0.0);
        ans[start_node] = 1.0;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int node = edges[i][0], desti = edges[i][1];
            double prob = succProb[i];
            adj.get(node).add(new Pair(desti, prob));
            adj.get(desti).add(new Pair(node, prob));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start_node, 1.0));
        while(pq.size()>0){
            Pair front = pq.poll();
            int node = front.node; double prob = front.prob;
            if(prob < ans[node]){
                continue;
            }
            for(Pair p : adj.get(node)){
                double totalProb = prob*p.prob;
                if(totalProb>ans[p.node]){
                    ans[p.node] = totalProb;
                    pq.add(new Pair(p.node, totalProb));
                }
            }
        }
        return ans[end_node];
    }
}