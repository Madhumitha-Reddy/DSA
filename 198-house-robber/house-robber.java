class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n - 1, nums, n, dp);
    }

    int helper(int index, int[] nums, int n, int[] dp){

        if(index == 0){
            return nums[index];
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int take = nums[index];
        if(index > 1){
            take = nums[index] + helper(index - 2, nums, n, dp);
        }
        int notTake = helper(index - 1, nums, n, dp);

        return dp[index] = Math.max(take, notTake);
    }
}