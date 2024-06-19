class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            start=Math.min(start,bloomDay[i]);
            end=Math.max(end,bloomDay[i]);
        }
        int ans=-1;
        int totalFlowers=m*k;
        if(totalFlowers>bloomDay.length){
            return ans;
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPossible(bloomDay,m,k,mid)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    private boolean isPossible(int bloomDay[],int m,int k,int days){
        int flowers=0;
        int bouquets=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=days){
                flowers++;
            }
            else{
                flowers=0;
            }
            if(flowers==k){
                bouquets++;
                flowers=0;
            }
        }
        return bouquets>=m;
    }
}
// T.C -> O(nlog(maxBloomDay)) where n= length of bloomDay array
// S.C -> O(1) no extra space required

// Define a function isPossible(int days) that returns true if we can make at least m bouquets using flowers that bloom in days or fewer days. This involves iterating through the bloomDay array and counting the number of consecutive flowers that have bloomed by days.
// The search space for the number of days will be from the minimum value in bloomDay (earliest possible bloom) to the maximum value in bloomDay (latest possible bloom).
// Perform binary search on the days, using the isPossible function to narrow down the minimum feasible number of days.