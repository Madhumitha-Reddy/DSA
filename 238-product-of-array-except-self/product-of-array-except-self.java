class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int prod = 1;
        int zeroCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
            }else{
                prod = prod * nums[i];
            }
        }
        
        for(int i=0; i<arr.length; i++){
            if(zeroCount > 1){
                arr[i] = 0;
            }else if (zeroCount == 1){
                if(nums[i] == 0){
                    arr[i] = prod; 
                }else{
                    arr[i] = 0;
                }
                
            }else{
                arr[i] = prod / nums[i];
            }
        }

        return arr;
    }
}