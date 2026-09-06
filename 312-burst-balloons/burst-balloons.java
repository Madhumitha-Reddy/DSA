class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(0, n - 1, 1, 1, nums, dp);
    }

    int helper(int i, int j, int left, int right, int[] nums, int[][] dp){
        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int maxi = 0;

        for(int k = i; k <= j; k++){


            int coins = left * nums[k] * right + helper(i, k - 1, left, nums[k], nums, dp) + helper(k + 1, j, nums[k], right, nums, dp);
            maxi = Math.max(maxi, coins);
        }

        return dp[i][j] = maxi;
    }
}