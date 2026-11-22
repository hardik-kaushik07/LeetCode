class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        // Set<Integer> st  = new HashSet<>();
        // for(int val: arr){
        //     set.add(val);
        // }
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int max = -1;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey().equals(entry.getValue())){
                max = Math.max(max, entry.getValue());
            }
        }
        return max;
    }
}