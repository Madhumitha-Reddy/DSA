class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        while(!map.isEmpty()){
            int max = 0;
            char maxChar = ' ';

            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                if(entry.getValue() > max){
                    max = entry.getValue();
                    maxChar = entry.getKey();
                }
            }

            for(int i=0; i<max; i++){
                sb.append(maxChar);
            }

            map.remove(maxChar);
        }

        return sb.toString();
    }
}