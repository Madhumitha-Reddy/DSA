class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }

        solveQueens(0, board, ans, n);
        return ans;
    }

    void solveQueens(int col, char[][] board, List<List<String>> ans, int n){
        if(col == n){

            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int row = 0; row<n; row++){
            if(isSafe1(row, col, board, n)){
                board[row][col] = 'Q';
                solveQueens(col + 1, board, ans, n);
                board[row][col] = '.'; 
            }
        }
    }

    boolean isSafe1(int row, int col, char[][] board, int n){
        int duprow = row;
        int dupcol = col;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        col = dupcol;
        row = duprow;

        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        row = duprow;
        col = dupcol;
        
        while(row < n && col >= 0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
}