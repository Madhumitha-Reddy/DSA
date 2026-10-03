class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return helper(n - 1, 0, nums, target);
    }

    int helper(int index, int sum, int[] nums, int target){
        if(index < 0){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }

        int take = 0;
        int notTake = 0;
        if(index >= 0){
            take = helper(index - 1, sum + nums[index], nums, target);
            notTake = helper(index - 1, sum - nums[index], nums, target);
        }

        return take + notTake;
    }
}