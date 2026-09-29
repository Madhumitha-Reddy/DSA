class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Integer.MAX_VALUE;

        int[][] dp = new int[m][n];
        for(int[] num : dp){
            Arrays.fill(num, Integer.MAX_VALUE);
        }
        for(int col = 0; col < n; col++){
            min = Math.min(min, helper(m - 1, col, matrix, m, n, dp));
        }
        return min;
    }

    int helper(int row, int col, int[][] matrix, int m, int n, int[][] dp){
        if(row == 0){
            return matrix[row][col];
        }

        if(dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }
        int min = Integer.MAX_VALUE;
        int diagLeft = Integer.MAX_VALUE;
        int below = Integer.MAX_VALUE;
        int diagRight = Integer.MAX_VALUE;
        if(col > 0){
            diagLeft = matrix[row][col] + helper(row - 1, col - 1, matrix, m, n, dp);
        }

        below = matrix[row][col] + helper(row - 1, col, matrix, m, n, dp);

        if(col < n - 1){
            diagRight = matrix[row][col] + helper(row - 1, col + 1, matrix, m, n, dp);
        }

        min = Math.min(diagLeft,Math.min(below, diagRight));
        return dp[row][col] = min;

    }
}