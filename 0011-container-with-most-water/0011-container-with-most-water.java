class Solution {
    public int maxArea(int[] arr) {
     int maxarea = 0;
     int i = 0 , j =arr.length-1;
     while(i<j){
        int width = j-i;
        int hight = Math.min(arr[i],arr[j]);
        int currArea = width*hight;
        if(currArea>maxarea){
            maxarea = currArea;
        }
        if(arr[i]<arr[j]){i++;}
        else{j--;}
     }
     return maxarea;
    }
}