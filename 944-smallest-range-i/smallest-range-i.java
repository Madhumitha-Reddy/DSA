class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int maxNum = nums[0];
        int minNum = nums[0];
        for(int i=0; i<nums.length; i++){
            if(maxNum < nums[i]){
                maxNum = nums[i];
            }if(minNum > nums[i]){
                minNum = nums[i];
            }
        }
        maxNum = maxNum - k;
        minNum = minNum + k;
        if(minNum > maxNum){
            return 0;
        }
        return maxNum - minNum;
    }
}