class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(0, n, dp);
    }

    int helper(int index, int n, int[] dp){
        if(index == n){
            return 1;
        }

        if(index > n){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int oneStep = helper(index + 1, n, dp);
        int twoStep = helper(index + 2, n, dp);

        return dp[index] = oneStep + twoStep;
    }
}