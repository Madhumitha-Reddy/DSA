class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 1, nums[0], nums[0]);
    }

    int helper(int[] nums, int index, int sum, int max){
        if(index == nums.length){
            return max;
        }

        sum = Math.max(nums[index], sum + nums[index]);
        max = Math.max(sum, max);
        return helper(nums, index + 1, sum, max);
    }
}