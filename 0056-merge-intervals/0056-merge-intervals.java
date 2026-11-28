
class Solution {
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {

            if(intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }
            else {
                List<Integer> lis = new ArrayList<>();
                lis.add(start);
                lis.add(end);
                list.add(lis);

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        List<Integer> lis = new ArrayList<>();
        lis.add(start);
        lis.add(end);
        list.add(lis);

        int[][] arr = new int[list.size()][2];

        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < 2; j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }

        return arr;
    }
}
