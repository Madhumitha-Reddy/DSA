class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        
        for(int j=0; j<cols; j++){
            if(board[0][j] == 'O'){
                dfs(board, 0, j, rows, cols);
            }

            if(board[rows - 1][j] == 'O'){
                dfs(board, rows - 1, j, rows, cols);
            }
        }

        for(int i=0; i<rows; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0, rows, cols);
            }

            if(board[i][cols - 1] == 'O'){
                dfs(board, i, cols - 1, rows, cols);
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }

                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c, int rows, int cols){
        if(r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O'){
            return;
        }

        board[r][c] = '#';

        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(board, nr, nc, rows, cols);
        }
    }
}