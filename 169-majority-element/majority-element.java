class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int num = nums[i];

            freq.put(num, freq.getOrDefault(num, 0) + 1);

            if(freq.get(num) > n / 2){
                return num;
            }
        }

        return -1;
    }
}