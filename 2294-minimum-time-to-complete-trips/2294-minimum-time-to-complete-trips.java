class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long min=0;
        long max=100000000000000L;
        // for(int i:time){
        //     max=Math.max(max,i);
        //     max=max*totalTrips;
        // }
        // Possible to replace above max: long max = Arrays.stream(time).max().getAsInt() * (long) totalTrips;
        while(min<max){
            long time_needed=min+(max-min)/2;
            long trips=0;
            for(int t:time){
                trips+=time_needed/t;
            }
            if(trips<totalTrips){
                min=time_needed+1;
            }
            else{
                max=time_needed;
            }
        }
        return min;
    }
}
// T.C -> O(nlog(T*min(time))) where T= totalTrips and n= length of time array
// S.C -> O(1)

// Initialize lowerbound and upperbound as min=0 and max=10^14
// Perform binary search between min and max to find the minimum time required to complete at least totalTrips
// Calculate the midpoint time_needed
// Calculate the total number of trips that can be completed within time_needed by summing up time_needed / t for each bus in the time array
// If the total trips are less than totalTrips, it means more time is needed, so update min to time_needed + 1
// Otherwise, total trips are sufficient or more than required, update max to time_needed
// Continue this process until min meets max