class Solution {
    public String longestPalindrome(String s) {

        String longest = "";
        for(int i=0; i<s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                String sub = s.substring(i, j);

                if(reverse(sub, 0, sub.length() - 1)){
                    if(sub.length() > longest.length()){
                        longest = sub;
                    } 
                }
            }
        }
        return longest;
    }

    boolean reverse(String s, int left, int right){

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}