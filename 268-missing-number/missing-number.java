class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for(int i=1; i<=n; i++){
            arr[i] = i;
        }

        for(int i=0; i<arr.length; i++){
            boolean found = false;
            for(int j = 0; j<nums.length; j++){
                if(arr[i] == nums[j]){
                    found = true;
                    break;
                }
            }

            if(!found){
                return arr[i];
            }
        }

        return -1;
    }
}