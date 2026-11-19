class Solution {
    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            if(board[i][0]=='O'){
                board[i][0] = '#';
                dfs(i, 0, board);
            }

            if(board[i][board[0].length-1]=='O'){
                board[i][board[0].length-1] = '#';
                dfs(i, board[0].length-1, board);
            }
        }
        for(int i = 0; i < board[0].length; i++){
            if(board[0][i]=='O'){
                board[0][i] = '#';
                dfs(0, i, board);
            }
            if(board[board.length-1][i]=='O'){
                board[board.length-1][i] = '#';
                dfs(board.length-1, i, board);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j]=='#'){
                    board[i][j] = 'O';
                }
                else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board){
        if(row>0){
            if(board[row-1][col]=='O'){
                board[row-1][col]='#';
                dfs(row-1, col, board);
            }
        }
        if(col>0){
            if(board[row][col-1]=='O'){
                board[row][col-1] = '#';
                dfs(row, col-1, board);
            }
        }
        if(row < board.length-1){
            if(board[row+1][col]=='O'){
                board[row+1][col] = '#';
                dfs(row+1, col, board);
            }
        }
        if(col < board[0].length-1){
            if(board[row][col+1]=='O'){
                board[row][col+1] = '#';
                dfs(row, col+1, board);
            }
        }
    }
}