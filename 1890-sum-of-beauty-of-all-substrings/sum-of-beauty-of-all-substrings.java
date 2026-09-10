class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
                for (int j = i; j <= s.length() - 1; j++) {
                    char ch = s.charAt(j);
                    map.put(ch, map.getOrDefault(ch, 0) + 1);

                    int max = 0;
                    int min = Integer.MAX_VALUE;

                    for(Map.Entry<Character, Integer> entry : map.entrySet()){
                        max = Math.max(max, entry.getValue());
                        min = Math.min(min, entry.getValue());    
                    }

                    sum += max - min;
                }
        }   

        return sum;
    }
}