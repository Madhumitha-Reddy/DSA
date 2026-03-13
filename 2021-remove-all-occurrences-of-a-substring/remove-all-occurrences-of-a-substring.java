class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder st = new StringBuilder();
        for(char c : s.toCharArray()){
            st.append(c);
            if(st.length() >= part.length()){
                if(st.substring(st.length() - part.length()).equals(part)){
                    st.delete(st.length() - part.length(), st.length());
                }
            }
        }

        return st.toString();
    }
}