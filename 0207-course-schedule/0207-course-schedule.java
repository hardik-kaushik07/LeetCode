// class Solution {
//     public boolean canFinish(int n, int[][] pre) {
//         List<List<Integer>> adj = new ArrayList<>();
//         int[] indegree = new int[n];
//         for(int i = 0; i < n; i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i = 0; i < pre.length; i++){
//             int a = pre[i][0], b = pre[i][1];
//             adj.get(b).add(a);
//             indegree[a]++;
//         }

//         Queue<Integer> q = new LinkedList<>();
//         List<Integer> ans = new ArrayList<>();

//         for(int i = 0; i < indegree.length; i++){
//             if(indegree[i]==0){
//                 q.add(i);
//             }
//         }

//         while(q.size()!=0){
//             int node = q.remove();
//             ans.add(node);
//             for(int i = 0; i < adj.get(node).size(); i++){
//                 indegree[adj.get(node).get(i)]--;
//                 if(indegree[adj.get(node).get(i)]==0){
//                     q.add(adj.get(node).get(i));
//                 }
//             }
//         }
//         if(ans.size()<n) return false;

//         return true;
//     }
// }

class Solution {
    static boolean ans ;
    public boolean canFinish(int n, int[][] pre) {
        ans = true;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
         for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < pre.length; i++){
            int a = pre[i][0], b = pre[i][1];
            adj.get(b).add(a);
        }
        for(int  i = 0; i < n; i++){
            if(vis[i]==false){
                dfs(i, adj, vis, path);
            }
        }
       return ans;
    }

    public void dfs(int i, List<List<Integer>> adj, boolean[] vis, boolean[] path){
        vis[i] = true;
        path[i] = true;
        for(int ele: adj.get(i)){

            if(!vis[ele]){
                dfs(ele, adj, vis, path);
            }

            if(path[ele]==true){
                ans = false;
                return;
            }
        }
        path[i] = false;
    }
}