class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }

    boolean helper(int[] nums, int index, int[] dp){
        if(index >= nums.length - 1){
            return true;
        }

        if(nums[index] == 0){
            return false;
        }

        if(dp[index] != -1){
            return dp[index] == 1;
        }

        for(int jump=1; jump <= nums[index]; jump++){
            if(helper(nums, index + jump, dp)){
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = 0;
        return false;
    }
}