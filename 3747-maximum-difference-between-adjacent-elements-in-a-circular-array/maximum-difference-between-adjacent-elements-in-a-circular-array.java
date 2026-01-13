class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = 0;
        for(int i=0; i<nums.length; i++){
            int mid = nums[i];
            int right = nums[(i+1) % n];
            int diff = Math.abs(right - mid);
            maxDiff = Math.max(diff, maxDiff);
        }
        return maxDiff;
    }
}