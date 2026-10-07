class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int total = 0;
        int sum = 0;
        for(int num : nums){
            total += num;
        }
        if(total < target){
            return 0;
        }
        for(int right = 0; right < nums.length; right++){
            int num = nums[right];
            sum += num;
            while(sum >= target){
                int len = right - left + 1;
                minLen = Math.min(minLen, len);
                sum -= nums[left];
                left++;
            }
        }

        return minLen;
    }
}