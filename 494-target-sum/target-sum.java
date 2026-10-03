class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        int[][] dp = new int[n][2 * totalSum + 1];
        for(int[] num : dp){
            Arrays.fill(num, -1);
        }
        return helper(n - 1, 0, nums, target, dp, totalSum);
    }

    int helper(int index, int sum, int[] nums, int target, int[][] dp, int totalSum){
        if(index < 0){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[index][sum + totalSum] != -1){
            return dp[index][sum + totalSum];
        }

        int take = 0;
        int notTake = 0;
        if(index >= 0){
            take = helper(index - 1, sum + nums[index], nums, target, dp, totalSum);
            notTake = helper(index - 1, sum - nums[index], nums, target, dp, totalSum);
        }

        return dp[index][sum + totalSum] = take + notTake;
    }
}