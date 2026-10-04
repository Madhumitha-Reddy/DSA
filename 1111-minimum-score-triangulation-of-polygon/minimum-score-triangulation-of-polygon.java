class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(0, n - 1, values, dp);
    }

    int helper(int i, int j, int[] values, int[][] dp){
        if(j - i < 2){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for(int k = i + 1; k < j; k++){
            int cost = values[i] * values[k] * values[j] + helper(i, k, values, dp) + helper(k, j, values, dp);
            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }
}