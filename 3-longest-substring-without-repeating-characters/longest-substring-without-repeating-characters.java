class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.get(ch) > 1){
                char ch2 = s.charAt(left);
                map.remove(ch2);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                left++;
            }
            int length = right - left + 1;
            max = Math.max(max, length);
        }

        return max;
    }
}