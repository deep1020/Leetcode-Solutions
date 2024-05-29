class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                pq.offer(matrix[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
// T.C -> O(n^2logk) The nested loops traverse the entire matrix of size n×n. For each element in the matrix, we perform an insert/delete into/from the priority queue, which takes O(logk).
// S.C -> O(k) store at most k+1 elements.

// Dry run
// Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
// queue: [15,13,13,12,11,10,9,5]
// If 1 is going to add in queue, it exceed queue size
// Now remove 1st element from queue [13,13,12,11,10,9,5,1]
// peek 1st element and return it so answer is 13