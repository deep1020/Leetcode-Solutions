class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> list = new ArrayList<>(); 
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] currentInterval=intervals[i];
            int[] lastMergedInterval=list.get(list.size()-1);
            if(currentInterval[0]<=lastMergedInterval[1]){
                lastMergedInterval[1]=Math.max(lastMergedInterval[1],currentInterval[1]);
            } 
            else{
                list.add(currentInterval);
            }
        }
        int[][] result=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }
}
// T.C -> O(nlogn) where n is the number of intervals in the input
// S.C -> O(n) it uses an additional ArrayList to store the merged intervals

// 1) Initialize an ArrayList to store the merged intervals. Add the first interval to the merged intervals list.
// 2) Iterate through the given intervals and for each interval, compare its start and end times 
//    with the previous interval's end time to determine if there's an overlap.
// 3) If there's an overlap, merge the intervals by updating the end time of the previous interval to the maximum of its end time and the end time of the current interval.
// 4) If there's no overlap, add the current interval to the list of merged intervals.
// 5) After iterating through all intervals, Convert the list of merged intervals to a 2D array and return it.

// corner case:
// intervals= [[1,4],[0,4]] 
// Output: [[1,4]]
// Expected output: [[0,4]]
// We need to sort interval based on start point: [[0,4],[1,4]] 