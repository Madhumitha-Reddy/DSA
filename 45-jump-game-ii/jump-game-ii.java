class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(0, nums, dp);
    }

    public int helper(int index, int[] nums, int[] dp){
        if(index >= nums.length - 1){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int mini = Integer.MAX_VALUE;
        for(int jump = 1; jump <= nums[index]; jump++){
            if(index + jump < nums.length){
                int step = helper(index + jump, nums, dp);

                if(step != Integer.MAX_VALUE){
                    mini = Math.min(mini, 1 + step);
                }
            }
        }

        return dp[index] = mini;
    }
}