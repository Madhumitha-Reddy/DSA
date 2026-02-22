class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > n / 3){
                list.add(key);
            }
        }

        return list;
    }
}