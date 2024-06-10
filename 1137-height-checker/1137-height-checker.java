class Solution {
    public int heightChecker(int[] heights) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int height:heights){
            if(height<min){
                min=height;
            }
            if(height>max){
                max=height;
            }
        }
        int count[]=new int[max-min+1];
        for(int height:heights){
            count[height-min]++;
        }
        int result=0;
        int currHeight=min;
        for(int i=0;i<heights.length;i++){
            while(count[currHeight-min]==0){
                currHeight++;
            }
            if(heights[i]!=currHeight){
                result++;
            }
            count[currHeight-min]--;
        }
        return result;
    }
}
// T.C -> O(n) n= number of elements in the heights array
// S.C -> O(m) m= max element of heights, size of count array (max-min+1)
// Count Sort Approach