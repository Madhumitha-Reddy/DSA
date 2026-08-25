class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        
    
        for(int i=0; i<n; i++){
            totalSum += nums[i];
        }
        if(totalSum % 2 != 0){
            return false;
        }

        int target = totalSum / 2;

        Boolean[][] dp = new Boolean[n][target + 1];

        return helper(0, target, nums, dp);
    }

    boolean helper(int index, int target, int[] nums, Boolean[][] dp){
        if(target == 0){
            return true;
        }

        if(index == nums.length){
            return false;
        }

         if(dp[index][target] != null){
            return dp[index][target];
        }

        boolean take = false;
        if(nums[index] <= target){
            take = helper(index + 1, target - nums[index], nums, dp);
        }

        boolean notTake =  helper(index + 1, target, nums, dp);

        return dp[index][target] = take || notTake;
    }
}