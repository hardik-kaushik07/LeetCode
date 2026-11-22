class Solution {
    public boolean checkString(String s) {
        int count = 0;
        if(s.charAt(0)=='a'){
            count++;
        }
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i)=='b'){
                count = 0;
            }
            if(count == 0 && s.charAt(i)=='a'){
                return false;
            }
        }
        if(s.charAt(0)=='b'){
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i)=='a'){
                    return false;
                }
            }
        }
        
        return true;
    }
}