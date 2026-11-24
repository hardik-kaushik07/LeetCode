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
        if(size[a]>size[b]){
            parent[b] = a; size[a] += size[b];
        }
        else{
            parent[a] = b; size[b] += size[a];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length +1];
        size = new int[edges.length+1];
        for(int i = 0; i < edges.length; i++){
            parent[i] = i;
            size[i] = 1;
        }
        int ans[] = new int[2];
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            if(leader(u)==leader(v)){
                ans[0] = u; ans[1] = v;
            }
            else{
                union(u,v);
            }
        }
        return ans;
    }
}