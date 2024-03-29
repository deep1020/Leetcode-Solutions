class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int jobs[][]=new int[n][3];
        for(int i=0;i<n;i++){
            jobs[i]=new int[]{startTime[i],endTime[i],profit[i]};
        }
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        Queue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int maxProfit=0;
        for(int job[]:jobs){
            while(!pq.isEmpty() && pq.peek()[0]<=job[0]){
                int cur[]=pq.poll();
                maxProfit=Math.max(maxProfit,cur[1]);
            }
            pq.offer(new int[]{job[1],maxProfit+job[2]});
        }
        while(!pq.isEmpty()){
            int cur[]=pq.poll();
            maxProfit=Math.max(maxProfit,cur[1]);
        }
        return maxProfit;
    }
}
// T.C -> O(nlogn)
// S.C -> O(n)