class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(m - 1, n - 1, m, n, dp);
    }
    int helper(int top, int left, int m, int n, int[][] dp){

        if(top == 0 || left == 0){
            return 1;
        }

        if(dp[top][left] != -1){
            return dp[top][left];
        }

        int up = 0;
        int leftPath = 0;
        if(m >= 0){
            up = helper(top - 1, left, m, n, dp);
        }
        if(n >= 0){
            leftPath = helper(top, left - 1, m, n, dp);
        }

        return dp[top][left] = up + leftPath;
    }
}