class Solution {
    public int findFinalValue(int[] nums, int original) {
        int i=0;
        while(i<=nums.length-1){
            if(original == nums[i]){
                i=0;
                original = 2 * original;
            }else{
                i++;
            }
        }


        return original;
    }
}