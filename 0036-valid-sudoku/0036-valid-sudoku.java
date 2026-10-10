class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(solve(board)) return true;
        return false;
    }
    public boolean solve(char[][] board){

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    char val = board[i][j];
                    board[i][j] = '.';

                    if(!isSafe(board, i, j, val)){
                        board[i][j] = val;
                        return false;
                    }

                    board[i][j] = val;
                }
            }
            
        }
        return true;
    }

    // public boolean isEmpty(char[][] board, int[] emptyCell){
    //     for(int i = 0; i < 9; i++){
    //         for(int j = 0; j < 9; j++){
    //             if(board[i][j] != '.'){
    //                 emptyCell[0] = i;
    //                 emptyCell[1] = j;

    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

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