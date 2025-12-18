class Solution {
    public int dominantIndex(int[] nums) {
        int maxNum = nums[0];
        int pos = 0;
        for(int i=0; i<nums.length; i++){
            if(maxNum < nums[i]){
                maxNum = nums[i];
                pos = i;
            }
        }
        for(int j=0; j<nums.length; j++){
            if(j != pos && maxNum < 2 * nums[j])return -1;
        }
        return pos;
        
    }
}