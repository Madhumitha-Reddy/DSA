class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;


        Queue<int[]> q = new LinkedList<>();
                boolean[][] visited = new boolean[rows][cols];



        int path = 0;


        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 || j == 0 || i == rows-1 || j == cols-1){
                    if(maze[i][j] == '.' && !(i == entrance[0] && j == entrance[1])){
                        q.offer(new int[]{i,j});                        visited[i][j] = true;

                    }
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};


        while(!q.isEmpty()){
                int size = q.size();
                path++;


                for(int i = 0; i < size; i++){
                    int[] curr = q.poll();
                    int r = curr[0];
                    int c = curr[1];

                    
                    for(int[] dir : directions){
                        int nr = r + dir[0];
                        int nc = c + dir[1];

                        if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && maze[nr][nc] == '.'&&!visited[nr][nc]){
                               if(nr == entrance[0] && nc == entrance[1]){
                            return path;
                        }
                            q.offer(new int[]{nr,nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
        }

        return -1;
    }
}