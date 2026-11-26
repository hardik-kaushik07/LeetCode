class Solution {
    public int compress(char[] chars) {
        StringBuilder s = new StringBuilder();
        if(chars.length == 1) {s.append(chars[0]); return s.length();}
        int count = 1;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == chars[i-1]){
                count++;
            }
            else{
                s.append(chars[i-1]);
                if(count>1){
                    s.append(count);
                }
                count = 1;
            }
        }
        s.append(chars[chars.length-1]);
        if(count > 1) s.append(count);
        for(int i = 0; i < s.length(); i++){
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}