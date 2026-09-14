class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i < t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int count = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

            if(map.containsKey(ch) && sMap.get(ch) <= map.get(ch)){
                count++;
            }

            while(count == t.length()){
                if(right - left + 1 < len){
                    len = right - left + 1;
                    start = left;
                }
                char remove = s.charAt(left);
                sMap.put(remove, sMap.get(remove) - 1);
                
                if(map.containsKey(remove) && sMap.get(remove) < map.get(remove)){
                    count--;
                }

                left++;
            }   
        }

        if(len == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start, start + len);
    }
}