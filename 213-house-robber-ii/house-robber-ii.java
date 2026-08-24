class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(helper(n - 1, 1, nums, dp1), helper(n - 2, 0, nums, dp2));
    }

    int helper(int index, int start, int[] nums, int[] dp){
        if(index < start) return 0;
        if(index == start) return nums[start];

        if(dp[index] != -1){
            return dp[index];
        }

        int take = nums[index] + helper(index - 2, start, nums, dp);
        int notTake = helper(index - 1, start, nums, dp);

        return dp[index] = Math.max(take, notTake);
    }
}