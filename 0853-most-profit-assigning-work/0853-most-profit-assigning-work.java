class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int jobs[][]=new int[difficulty.length][2];
        for(int i=0;i<difficulty.length;i++){
            jobs[i][0]=difficulty[i];
            jobs[i][1]=profit[i];
        }
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        Arrays.sort(worker);
        int maxProfit=0;
        int totalProfit=0;
        int index=0;
        for(int ability:worker){
            while(index<difficulty.length && ability>=jobs[index][0]){
                maxProfit=Math.max(maxProfit,jobs[index][1]);
                index++;
            }
            totalProfit+=maxProfit;
        }
        return totalProfit;
    }
}
// T.C -> O(nlogn+mlogm) sorting jobs and workers take O(nlogn) and O(mlogm) respectively
// while loop inside for loop runs in O(n+m) time
// S.C -> O(n+m) storing jobs and sorted workers

// 1) combine difficulty and profit into 2D array jobs
// 2) Sort jobs by their difficulty
// 3) Sort workers by their ability
// 4) Use greedy approach to maximize profit for each worker
// - Keep track of maximum profit that can be achieved for any difficulty less than or equal to worker's ability
// - Add this maximum profit to the total profit
// 5) After iterating through all workers, return total profit