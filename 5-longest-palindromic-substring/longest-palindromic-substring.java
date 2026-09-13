class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for(int i=0; i<s.length(); i++){
           for(int j=i; j<s.length(); j++){
                String sub = s.substring(i, j + 1);
                String pal = palindrome(sub, 0, sub.length()-1, "");

                if(!pal.equals("") && pal.length() > longest.length()){
                    longest = pal;
                }
           }
        }

        return longest;
    }

    String palindrome(String s, int left, int right, String current){

        while(left < right){

            if(s.charAt(left) != s.charAt(right)) {
                return "";
            }

            left++;
            right--;
        }

        return s;
    }
}