class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        int maxFreq = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            if((right - left + 1) - maxFreq > k){
                char ch2 = s.charAt(left);
                map.put(ch2, map.get(ch2) - 1);
                
                left++;
            }

            int length = right - left + 1;
            max = Math.max(max, length);
        }

        return max;
    }
}