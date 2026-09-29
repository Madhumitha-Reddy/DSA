class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, cost, n, dp);
    }

    int helper(int index, int[] cost, int n, int[] dp){

        if(index == 0 || index == 1){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int min = Integer.MAX_VALUE;

        int oneStep = cost[index - 1] + helper(index - 1, cost, n, dp);
        int twoStep = cost[index - 2] + helper(index - 2, cost, n, dp);

        return dp[index] = Math.min(oneStep, twoStep);
    }
}