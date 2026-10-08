class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int val = 0;
        for(int i = 0; i < s.length(); i++){
           if(s.charAt(i)=='('){
            if(val>0){
                ans += s.charAt(i);
            }
            val++;
           }
           else{
            val--;
            if(val>0){
                ans += s.charAt(i);
            }
           }
        }
        return ans;
    }
}