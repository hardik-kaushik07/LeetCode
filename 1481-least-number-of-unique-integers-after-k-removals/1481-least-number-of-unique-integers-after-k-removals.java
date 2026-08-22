class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele: arr){
            map.put(ele, map.getOrDefault(ele,0)+1);
        }
       List<Integer> list = new ArrayList<>();
       for(int val: map.values()){
        list.add(val);
       }

       Collections.sort(list);
        int count = 0;
       for(int  i = 0; i < list.size(); i++){
        if(k==0){
            break;
        }
        if(list.get(i)<=k){
            k = k-list.get(i);
            count++;
            }
       }
       return  map.size()-count;
    }
}