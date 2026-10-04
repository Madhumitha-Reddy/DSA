class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(1, n, n, dp);
    }

    int helper(int i, int j, int n, int[][] dp){
        if(i >= j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++){
            int cost = k + Math.max(helper(i, k - 1, n, dp), helper(k + 1, j, n, dp));
            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }
}