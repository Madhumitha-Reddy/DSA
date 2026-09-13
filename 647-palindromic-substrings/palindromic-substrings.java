class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                String sub = s.substring(i, j + 1);
                if(palindrome(sub, 0, sub.length() - 1)){
                    count++;
                }
            }
        }

        return count;
    }

    boolean palindrome(String s, int left, int right){
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