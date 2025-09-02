class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxFreq = 0;
        int l=0;
        int r=0;
        HashMap<Character, Integer> hash = new HashMap<>(); 
        while(r < s.length()){
            char c = s.charAt(r);
            hash.put(c, hash.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, hash.get(c));
            if(r - l + 1 - maxFreq > k){
                char leftChar = s.charAt(l);
                hash.put(leftChar, hash.get(leftChar) - 1);  
                l++;
            }
            if(r - l + 1 - maxFreq <= k){
                maxLength = Math.max(maxLength, r-l+1);
            }
            r++;
        }
        return maxLength;
    }
}