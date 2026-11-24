class Solution {
    public int[] parent, size;
    public int leader(int a){
        if(parent[a] == a) return a;
        int lead = leader(parent[a]);
        parent[a] = lead;
        return lead;
    }
    public void union(int a, int b){
        a = leader(a); b = leader(b);
        if(a == b) return;
        if(size[a]>size[b]){
            parent[b] = a; size[a] += size[b];
        }
        else{
            parent[a] = b; size[b] += size[a];
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] indegree = new int[edges.length + 1];
        int[] parentEdge = new int[edges.length + 1];

        int first = -1, second = -1;
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if(indegree[v] == 0) {
                indegree[v] = i + 1;
            }
            else {
                first = indegree[v] - 1;
                second = i;
                break;
            }
        }
            parent = new int[edges.length +1];
        size = new int[edges.length+1];
        for(int i = 0; i <= edges.length; i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            if(i == second) continue;

            if(leader(u) == leader(v)) {
                if(second == -1) {
                    return edges[i];
                }
                return edges[first];
            }
            else{
                union(u,v);
            }
        }
        return edges[second];
    }
}