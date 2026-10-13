class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        int row = 0, col = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if (solve(board, word, vis, i, j, 0)) {
                        return true;}
                }
            }
        }
        return false;
    }

    public boolean solve(char[][] board, String word, boolean[][] vis, int row, int col, int idx){
        if(idx == word.length()){
            return true;
        }

    if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || vis[row][col] || board[row][col]!= word.charAt(idx)){
        return false;
    }
        
            vis[row][col] = true;
            
            boolean isEqual1 = solve(board, word, vis, row+1, col, idx+1);

            boolean isEqual2 = solve(board, word, vis, row-1, col, idx+1);

            boolean isEqual3 = solve(board, word, vis, row, col+1, idx+1);

            boolean isEqual4 = solve(board, word, vis, row, col-1, idx+1);

            vis[row][col] = false;

            if(isEqual1 == true || isEqual2 == true || isEqual3 == true || isEqual4 == true){
                return true;
            }

            else{
                return false;
            }
    }
}