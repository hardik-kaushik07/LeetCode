class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int  i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        List<List<String>> ans = new ArrayList<>();
        solve(board, n, ans, 0);

        return ans;
    }

    public void solve(char[][] board, int n, List<List<String>> ans, int col){

        if(col >= n){
            List<String> list = new ArrayList<>();
            for(int  i = 0; i < n; i++){
                list.add(new String(board[i]));
            }
            ans.add(list);
            return;
        }

        for(int row = 0; row < n; row++){
            if(isSafeToPlace(row, col, board, n)){
                board[row][col] = 'Q';

                solve(board, n, ans, col+1);

                board[row][col] = '.';
            }
        }
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