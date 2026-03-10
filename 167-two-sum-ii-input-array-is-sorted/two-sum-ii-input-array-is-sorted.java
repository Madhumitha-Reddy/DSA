class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size[] = new int[2];

        for(int i=0; i<numbers.length; i++){

            int result = target - numbers[i];

            if(map.containsKey(result)){
                size[0] = map.get(result) + 1;
                size[1] = i + 1;
                return size;
            }

            map.put(numbers[i],i);

        }

        return size;
    }
}