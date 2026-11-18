class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] inOrder = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            
                int u = prerequisites[i][0];
                int v = prerequisites[i][1];

                adj.get(v).add(u);
                inOrder[u]++;
            
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inOrder.length; i++){
            if(inOrder[i]==0){
                q.add(i);
            }
        }
        while(q.size()>0){
            int front = q.poll();
            ans.add(front);
            for(int ele : adj.get(front)){
                inOrder[ele]--;
                if(inOrder[ele]==0){
                    q.add(ele);
                }
            }
        }
        
        int[] ans2 = new int[ans.size()];
        if(ans.size()!= numCourses){
            return new int[0];
        }
        for(int i = 0; i < ans.size(); i++){
            ans2[i] = ans.get(i);
        }
        return ans2;
    }
}