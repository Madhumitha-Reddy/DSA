class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int k = 0;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) <= 2){
                nums[k] = num;
                k++;
            }
        }

        return k;
    }
}