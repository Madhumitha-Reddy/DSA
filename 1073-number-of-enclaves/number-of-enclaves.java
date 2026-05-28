class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

    

        for(int j=0; j<cols; j++){
            if(grid[0][j] == 1){
                dfs(grid, 0, j, rows, cols);
            }

            if(grid[rows - 1][j] == 1){
                dfs(grid, rows - 1, j, rows, cols);
            }
        }

        for(int i=0; i<rows; i++){
            if(grid[i][0] == 1){
                dfs(grid, i, 0, rows, cols);
            }

            if(grid[i][cols - 1] == 1){
                dfs(grid, i, cols - 1, rows, cols);
            }
        }

        int count = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                   count++;
                }
            }
        }

        return count;

    }

    public void dfs(int[][] grid, int r, int c, int rows, int cols){
        if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != 1){
            return;
        }

        grid[r][c] = 0;

        int[][] directions = {{-1, 0},{0, -1},{0, 1},{1, 0}};
        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            
            dfs(grid, nr, nc, rows, cols);
        
        }
    }
}