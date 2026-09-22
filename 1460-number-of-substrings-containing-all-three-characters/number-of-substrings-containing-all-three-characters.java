class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(map.size() == 3){
                count += s.length() - right;
                char ch2 = s.charAt(left);
                map.put(ch2, map.get(ch2) - 1);

                if(map.get(ch2) == 0){
                    map.remove(ch2);
                }

                left++;
            }
        }

        return count;
    }
}