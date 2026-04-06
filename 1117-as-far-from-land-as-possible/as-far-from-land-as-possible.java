class Solution {
    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[rows][cols];

        int[][] dirc = {
            {1,0},{-1,0},{0,1},{0,-1}
        };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        if (q.isEmpty() || q.size() == rows * cols) return -1;

        int distance = -1;

        while(!q.isEmpty()){
            int size = q.size();
            distance++;

            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] d:dirc){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }

        return distance;
    }
}