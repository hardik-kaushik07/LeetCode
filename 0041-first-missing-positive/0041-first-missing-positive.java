class Solution {
    public int firstMissingPositive(int[] nums) {
      int[] newNums = Arrays.stream(nums).filter(ele -> ele > 0).toArray();

      Arrays.sort(newNums);
      int target = 1;
      for(int i = 0; i < newNums.length; i++){
        if(newNums[i]==target){
            target ++;
        }
        else if(newNums[i] > target){
            return target;
        }
      }
      return target;
    }
}