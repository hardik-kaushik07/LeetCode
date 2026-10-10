class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int  i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        return solve(board, n, 0);
    }

    public int solve(char[][] board, int n, int col){

        if(col >= n){
            return  1;
        }
        int total = 0;
        for(int row = 0; row < n; row++){
            if(isSafeToPlace(row, col, board, n)){
                board[row][col] = 'Q';

                total += solve(board, n, col+1);

                board[row][col] = '.';
            }
        }
        return total;
    }

    public boolean isSafeToPlace(int row, int col, char[][] board, int n){

        for(int i = col-1; i >= 0; i--){
            if(board[row][i] == 'Q'){
                return false;
            }
        }
    int i = row, j = col;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q'){
                return  false;
            }
            i = i - 1; j = j - 1;
        }
        i = row;
        j = col;
        while(i < n && j >= 0){
            if(board[i][j] == 'Q'){
                return  false;
            }
            i = i + 1; j = j - 1;
        }
        return true;
    }
}