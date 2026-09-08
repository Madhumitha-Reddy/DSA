class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 2][n + 2];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(0, nums.length - 1, nums, dp);
    }

    int helper(int i, int j,  int[] nums, int[][] dp){
        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int maxi = Integer.MIN_VALUE;

        for(int k=i; k<=j; k++){

            int left = (i == 0) ? 1 : nums[i - 1];
            int right = (j == nums.length - 1) ? 1 : nums[j + 1];
            int coins = left * nums[k] * right + helper(i, k - 1 , nums, dp) + helper(k + 1, j, nums, dp);
            maxi = Math.max(maxi, coins);
        }

        return dp[i][j] = maxi;
    }
}