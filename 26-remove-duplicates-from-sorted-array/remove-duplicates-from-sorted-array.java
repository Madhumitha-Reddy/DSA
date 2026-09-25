class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        for(int i=0; i< n - 1; i++){
            if(nums[i] == nums[i + 1]){
                for(int j = i + 1; j<nums.length - 1; j++){
                    nums[j] = nums[j + 1];
                }

                n--;
                i--;
            }           
        }
        return n;
    }
}