class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int left = 0;
        int zeroes = 0;
        for(int right = 0; right < nums.length; right++){
            
            if(nums[right] == 0){
                zeroes++;
            }

            if(zeroes > k){
                if(nums[left] == 0){
                    zeroes--;
                }
                left++;
            }
            int len = right - left + 1; 
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}