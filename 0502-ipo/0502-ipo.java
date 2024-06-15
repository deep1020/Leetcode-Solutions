class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int projects[][]=new int[profits.length][2];
        for(int i=0;i<profits.length;i++){
            projects[i][0]=capital[i];
            projects[i][1]=profits[i];
        }
        Arrays.sort(projects,(a,b)->Integer.compare(a[0],b[0]));
        Queue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        int currIndex=0;
        for(int i=0;i<k;i++){
            while(currIndex<profits.length && projects[currIndex][0]<=w){
                maxHeap.offer(projects[currIndex][1]);
                currIndex++;
            }
            if(maxHeap.isEmpty()){ 
                break;
            } 
            w+=maxHeap.poll();
        }
        return w;
    }
}
// T.C -> O(nlogn) sorting projects takes O(nlogn), Adding and removing elements from maxHeap takes O(logn) for each operation. Add all projects to the maxHeap take O(nlogn)
// S.C -> O(n) storing projects array takes O(n) and maxHeap can hold up to O(n) elements
// 1) create a 2D array of projects where 1D consists of capital required and 2D profit of a project
// 2) sort projects based on capital required in ascending order
// 3) Use maxHeap (PriorityQueue) to keep track of profits of projects that can be started with current available capital
// 4) For each iteration up to k, add all projects that can be started with current capital to the maxHeap
// 5) If there are no more projects left due to insufficient capital, there's no point in continuing the loop for the remaining iterations of k. It means if maxHeap becomes empty, we'll break a loop
// 6) select the project with highest profit removing from maxHeap and update the capital