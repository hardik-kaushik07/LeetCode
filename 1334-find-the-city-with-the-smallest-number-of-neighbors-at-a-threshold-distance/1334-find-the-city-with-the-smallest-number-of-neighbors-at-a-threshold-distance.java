class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {

        int[][] dis = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dis[i][j] = Integer.MAX_VALUE;
                if(i==j) dis[i][j] = 0;
            }
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0], v =edges[i][1], wt = edges[i][2];
            dis[u][v] = wt;
            dis[v][u] = wt;

        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i==j) continue;
                     if(dis[i][k] != Integer.MAX_VALUE &&
                       dis[k][j] != Integer.MAX_VALUE) {
                        if(dis[i][j] > dis[i][k] + dis[k][j]) {
                            dis[i][j] = dis[i][k] + dis[k][j];
                        }
                    }
                }
            }
        }
            int min = -1;
            int cityCount = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                int count = 0;
                for(int  j = 0; j < n; j++){
                    if(i!=j && dis[i][j] <= threshold){
                        count++;
                    }
                }
                if(count <= cityCount) {
                        cityCount = count;
                        min = i;
                     }
            }
        return min;
    }
}