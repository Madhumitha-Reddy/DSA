class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int i=0; i<4; i++){
                int r = curr[0] + drow[i];
                int c = curr[1] + dcol[i];

                if (r >= 0 && c >= 0 && r < m && c < n && image[r][c] == oldColor) {
                    image[r][c] = color;
                    q.add(new int[]{r, c});
                }
            }
        }

        return image;
    }
}