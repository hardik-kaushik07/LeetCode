class Solution {
    public int maxDepth(String s) {
        int maxCount  = 0;
        int count = 0;

        for(char ch: s.toCharArray()){
            if(ch==')'){
                count--;
                continue;
            }
            if(ch!='('){
                continue;
            }
            count++;

            if(count>maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }
}