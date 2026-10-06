class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       return helper(nums, k) - helper(nums, k - 1);
    }

    public int helper(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        int odd = 0;
        for(int right = 0; right < nums.length; right++){
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);

            if(num % 2 != 0){
                odd++;
            }

            while(odd > k){

                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }

                if(nums[left] % 2 != 0){
                    odd--;
                }
                
                left++;
            }

                count += right - left + 1;
            
        }

        return count;
    }
}