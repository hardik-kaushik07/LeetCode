class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        int count = 0;
        while(n>=remove){
            count ++;
            n = n - remove;
            remove--;
        }
        if(count%2 == 0) return false;
        return true;
    }
}