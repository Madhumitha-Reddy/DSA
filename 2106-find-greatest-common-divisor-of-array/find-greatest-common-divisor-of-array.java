class Solution {
    public int findGCD(int[] nums) {
        int smallNum = nums[0];
        int greatNum = nums[0];
        for(int i=0; i<nums.length; i++){
            if(nums[i] < smallNum){
                smallNum = nums[i];
            }
            if(nums[i] > greatNum){
                greatNum = nums[i];
            }
        }

        while(smallNum != 0){
            int rem = greatNum % smallNum;
            greatNum = smallNum;
            smallNum = rem;
        }
        return greatNum;
        
    }
}