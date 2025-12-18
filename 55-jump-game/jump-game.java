class Solution {
    public boolean canJump(int[] nums) {
        int jumps = 0;
        int maxNum = nums[0];
        for(int i=0; i<nums.length; i++){
            if(maxNum < i){
              return false;
            }
            if(maxNum < i + nums[i]){
                maxNum = i + nums[i];
            }
        }
        return true;
    }
}