class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> Hash = new HashMap<>();
        int maxLength = 0;
        int l=0;
        int r=0;
        while(r < s.length()){
            if(Hash.containsKey(s.charAt(r))){
                if(Hash.get(s.charAt(r)) >= l){
                    l = Hash.get(s.charAt(r)) + 1;
                }
            }
            int len = r - l + 1;
            maxLength = Math.max(len, maxLength);
            Hash.put(s.charAt(r), r);
            r++;
        }
        return maxLength;
    }
}