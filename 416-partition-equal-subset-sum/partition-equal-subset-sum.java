class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int total = 0;
        for(int num : nums){
            total += num;
        }

        if(total % 2 != 0){
            return false;
        }

        int half = total / 2;

        Boolean[][] dp = new Boolean[n + 1][half + 1];


        return helper(0, 0, n, nums, total, half, dp);
    }

    boolean helper(int index, int sum, int n, int[] nums, int total, int half, Boolean[][] dp){

        if(sum == half){
            return true;
        }

        if (sum > half) {
            return false;
        }

        if(index == n){
            return false;
        }

        if(dp[index][sum] != null){
            return dp[index][sum];
        }


        boolean notTake = helper(index + 1, sum, n, nums, total, half, dp);
        boolean take = helper(index + 1, sum + nums[index], n, nums, total, half, dp);

        return dp[index][sum] = take || notTake;
    }
}