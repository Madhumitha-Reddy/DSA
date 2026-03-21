class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j, 0});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] p = q.poll();

            int r = p[0];
            int c = p[1];
            int t = p[2];

            time = Math.max(time, t);

            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && grid[nrow][ncol] == 1){
                    grid[nrow][ncol] = 2;
                    q.add(new int[]{nrow, ncol, t + 1});
                    fresh--;
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}