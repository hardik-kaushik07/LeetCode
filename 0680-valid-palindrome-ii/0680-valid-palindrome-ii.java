class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        int a = 0, b = 0;
        while(i < j){
            if(s.charAt(i)!=s.charAt(j)){
                a = i;
                b = j;
                break;
            }
            i++; j--;
        }
        
        if(i>=j) return true;
        int x = a+1, y = b;
        while(x < y){
            if(s.charAt(x)==s.charAt(y)){
                x++; y--;
            }
            else{
                break;
            }
        }
        if(x>=y) return true;

        x = a; y = b-1;
        while(x<y){
            if(s.charAt(x)==s.charAt(y)){
                x++; y--;
            }
            else{
                break;
            }
        }
        if(x>=y) return true;
        return false;
    }
}