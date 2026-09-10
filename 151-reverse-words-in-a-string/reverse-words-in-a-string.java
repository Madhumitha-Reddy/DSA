class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=s.length() - 1; i>= 0; i--){
            if(s.charAt(i) != ' '){
                st.push(s.charAt(i));
            }else{
                if(!st.isEmpty()){
                    while(!st.isEmpty()){
                        sb.append(st.pop());
                    }

                    sb.append(' ');
                }
            }
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString().trim();
    }
}