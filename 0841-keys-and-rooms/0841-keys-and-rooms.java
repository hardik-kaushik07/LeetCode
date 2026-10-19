class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(0, visited, rooms);
        for(int i = 0; i < n; i++){
            if(visited[i]==false) return false;
        }
        return true;
    }


    void dfs(int start, boolean[] visited, List<List<Integer>> rooms){
        visited[start] = true;
        List<Integer> ele = rooms.get(start);
        int n = ele.size();

        for(int i = 0; i < n; i++){
            if(visited[ele.get(i)]==false){
                dfs(ele.get(i), visited, rooms);
            }
        }
    }


    void bfs(int start, boolean[] visited, List<List<Integer>> rooms){

        Queue<Integer> q = new  LinkedList<>();
        q.add(start);
        while(q.size()>0){
            int front = q.remove();
            List<Integer> ele = rooms.get(front);
            for(int i = 0; i < ele.size(); i++){
            if(visited[ele.get(i)]==false){
                q.add(ele.get(i));
                visited[ele.get(i)] = true;
                 }
            }
        }
    }
}