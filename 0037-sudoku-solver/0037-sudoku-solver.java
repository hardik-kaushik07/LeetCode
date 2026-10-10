class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board){
        int[] emptyCell = new int[2];
        if(!isEmpty(board, emptyCell)){
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for(int i = 1; i <= 9; i++){
            char value = (char)(i + '0');
            if(isSafe(board, row, col, value)){

                board[row][col] = value;

                if(solve(board) == true){
                    return true;
                }

                board[row][col] = '.';
            }
        }
        return false;
    }

    public boolean isEmpty(char[][] board, int[] emptyCell){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    emptyCell[0] = i;
                    emptyCell[1] = j;

                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSafe(char[][] board, int row, int col, char value){

        for(int i = 0; i < 9; i++){
            if(board[row][i] == value){
                return false;
            }
        }

        for(int i = 0; i < 9; i++){
            if(board[i][col] == value){
                return false;
            }
        }
        int rowIndex = row - row%3;
        int colIndex = col - col%3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int actualRow = rowIndex + i;
                int actualCol = colIndex + j;
                if(board[actualRow][actualCol] == value){
                    return false;
                }
            }
        }
        return true;
    }
}