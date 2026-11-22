
class Solution {
    public int myAtoi(String s) {
        String str = s.trim();
        if(str.length() == 0){
            return 0;
        }

        int count = 0;
        long num = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int start = 0;
        if(str.charAt(0)=='-'){
            count++;
            start++;
        }
        else if(str.charAt(0)=='+'){
            start++;
        }
        for(int i = start; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                int digit = str.charAt(i)-'0';
                num = num*10 + digit;
                if(count > 0){
                    num *= -1;
                    if(num < min){
                        return min;
                    }
                    num *= -1;
                }
                else{
                    if(num > max){
                        return max;
                    }
                }
            }
            else{
                break;
            }
        }
        if(count > 0){
            num *= -1;
        }
        return (int)num;
    }
}
