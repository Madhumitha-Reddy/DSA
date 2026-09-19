class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for(int right=0; right < fruits.length; right++){

            int fruit = fruits[right];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            
            while(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            int length = right - left + 1;
            max = Math.max(max, length);
        }

        return max;
    }
}