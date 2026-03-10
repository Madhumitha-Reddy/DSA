class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size[] = new int[2];

        for(int i=0; i<nums.length; i++){

            int result = target - nums[i];

            if(map.containsKey(result)){
                size[0] = i;
                size[1] = map.get(result);
                return size;
            }

                        map.put( nums[i],i);

        }

        return size;
    }
}