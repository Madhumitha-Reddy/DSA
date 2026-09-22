class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;

        StringBuilder sb = new StringBuilder();
        String result = "";
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            sb.append(ch);
            if(map.containsKey(ch)){
                if(map.get(ch) > 0){
                    count++;
                }
                map.put(ch, map.get(ch) - 1);
            }

            while(count == t.length()){
                if(sb.length() < min){
                    min = sb.length();
                    result = sb.toString();
                }

                char ch2 = s.charAt(left);

                if(map.containsKey(ch2)){
                    map.put(ch2, map.get(ch2) + 1);

                    if(map.get(ch2) > 0){
                        count--;
                    }
                }
                sb.deleteCharAt(0);
                left++;
            }
        }

        return result;
    }
}