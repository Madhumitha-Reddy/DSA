class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1){
            return -1;
        }

        int[][] dirc = {
            {1,0},{-1,0},{0,1},{0,-1},
            {1,1},{1,-1},{-1,1},{-1,-1},
        };

        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        int pathlength = 1;

        q.offer(new int[]{0,0});

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if(r == grid.length-1 && c == grid[0].length-1) return pathlength;

                for(int[] d : dirc){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nc >= 0 && nr <= grid.length-1 && nc <= grid[0].length-1 && grid[nr][nc] == 0 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }

            pathlength++;
    
        }

        return -1;
    }
}