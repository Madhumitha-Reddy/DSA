class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        
        int sum = 0;

        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        return helper(0, 0, nums, target, 0);

    }

    int helper(int index,int sum, int[] nums, int target, int count){
       
        if(index == nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        
        int add =  helper(index + 1 ,sum + nums[index], nums, target, count);

        int subtract = helper(index + 1, sum - nums[index], nums, target, count);

        return add + subtract;
    }
}