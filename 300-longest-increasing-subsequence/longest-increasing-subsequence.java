class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(0, -1, nums, dp);
    }
    int helper(int index, int prev_index, int[] nums, int[][] dp){
        if(index == nums.length){
            return 0;
        }

        if(dp[index][prev_index + 1] != -1){
            return dp[index][prev_index + 1];
        }

        int notTake = 0 + helper(index + 1, prev_index, nums, dp);
        int take = 0;

        if(prev_index == -1 || nums[index] > nums[prev_index]){
            take = 1 + helper(index + 1, index, nums, dp);
        }
        return dp[index][prev_index + 1] = Math.max(take, notTake);
    }
}