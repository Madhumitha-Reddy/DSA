class Solution {
    public boolean canPartition(int[] nums) {

        int total = 0;
        for(int num : nums){
            total += num;
        }
        
        if(total % 2 != 0){
            return false;
        }

        int target = total / 2;
        Boolean[][] dp = new Boolean[nums.length][total + 1];
        return helper(0, 0, nums, target, dp);
    }

    boolean helper(int index, int sum, int[] nums, int target, Boolean[][] dp){

        if(sum == target){
            return true;
        }

        if(index == nums.length || sum > target){
            return false;
        }

        if(dp[index][sum] != null){
            return dp[index][sum];
        }

        boolean take = helper(index + 1, sum + nums[index], nums, target, dp);
        boolean notTake = helper(index + 1, sum, nums, target, dp);

        return dp[index][sum] = take || notTake;
    }
}