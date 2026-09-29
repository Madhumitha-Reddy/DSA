class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(m - 1, n - 1, obstacleGrid, m, n, dp);
    }

    int helper(int top, int left, int[][] obstacleGrid, int m, int n, int[][] dp){

        if(obstacleGrid[top][left] == 1){
            return 0;
        }
        if(top == 0 && left == 0){
            return 1;
        }

        if(dp[top][left] != -1){
            return dp[top][left];
        }
        int up = 0;
        int leftPath = 0;
        if(top > 0){
            up = helper(top - 1, left, obstacleGrid, m, n, dp);
        }
        if(left > 0){
            leftPath = helper(top, left - 1, obstacleGrid, m, n, dp);
        }

        return dp[top][left] = up + leftPath;
    }
}