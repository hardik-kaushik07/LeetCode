class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, color, iniColor, visited);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color, int iniColor, boolean[][] visited){
        if(sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0 || visited[sr][sc] || image[sr][sc] != iniColor){
            return;
        }
        visited[sr][sc] = true;
        image[sr][sc] = color;
        dfs(image, sr-1, sc, color, iniColor, visited);
        dfs(image, sr+1, sc, color, iniColor, visited);
        dfs(image, sr, sc-1, color, iniColor, visited);
        dfs(image, sr, sc+1, color, iniColor, visited);
    }
}