class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroes = 0;
        int max = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zeroes++;
            }

            while(zeroes > k){
                if(nums[left] == 0){
                    zeroes--;
                }
                left++;
            }

            int length = right - left + 1;
            max = Math.max(max, length);
        }

        return max;
    }
}