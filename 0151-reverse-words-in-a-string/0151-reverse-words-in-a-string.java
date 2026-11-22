class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        StringBuilder st = new StringBuilder();
        for(int i = str.length-1; i >= 0; i--){
            st.append(str[i]);
            if(i!=0){
                st.append(" ");
            }
        }
        return st.toString();
    }
}