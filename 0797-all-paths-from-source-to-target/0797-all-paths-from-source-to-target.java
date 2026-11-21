class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, ans, path, graph);
        return ans;
    }
    public void dfs(int node, List<List<Integer>> ans, List<Integer> path, int[][] graph){

        path.add(node);
        if(node == graph.length-1){
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        for(int ele : graph[node]){
            dfs(ele, ans, path, graph);
        }

        path.remove(path.size()-1);
    }
}