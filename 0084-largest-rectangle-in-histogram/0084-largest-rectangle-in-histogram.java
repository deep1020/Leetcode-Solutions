class Solution{
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=heights.length;i++){
            while(!st.isEmpty() && (i==heights.length || heights[i]<heights[st.peek()])){
                int height=heights[st.pop()];
                int width=st.isEmpty()?i : i-st.peek()-1;
                maxArea=Math.max(maxArea,height*width);
                System.out.println(maxArea);
            }
            st.push(i);
            // System.out.println(st.size());
        }
        return maxArea;
    }    
}
// T.C -> O(n)
// S.C -> O(n)


class Solution2 {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0){
            return 0;
        }
        return calculateArea(heights,0, heights.length-1);
    }
    public int calculateArea(int heights[],int start,int end){
        if(start>end){
            return 0;
        }
        int minIndex=start;
        for(int i=start;i<=end;i++){
            if(heights[i]<heights[minIndex]){
                minIndex=i;
            }
        }
        int area1=heights[minIndex]*(end-start+1);
        int left=calculateArea(heights,start,minIndex-1);
        int right=calculateArea(heights,minIndex+1,end);
        return Math.max(area1,Math.max(left,right));
    }
}
// Time Limit Exceeded
// T.C -> O(nlogn) In each recursive call, the function iterates over all the elements in the given range to find the index of the minimum height bar, which takes O(n) time and each recursive call divides the problem into two subproblems of roughly half the size, which takes O(logn) time. So overall O(nlogn) time
// S.C -> O(n) It depends on the depth of the recursion and it is determined by the height of the histogram, the worst-case space complexity is O(n)

// 1) Start with the largestRectangleArea function which takes an array heights representing the histogram bars.
// 2) Check if the heights array is empty. If it is, return 0 as there's no rectangle possible.
// 3) Call the calculateArea function with start as 0 and end as heights.length-1
// 4) In the calculateArea function:
//  - Base case: At any point, if start is greater than end, return 0.
//  - Find the index of the minimum height bar in the range [start, end] call it minIndex.
//  - Calculate the area area1 by multiplying the height at minIndex with the width (end - start + 1).
//  - Recursively call calculateArea for left subarray from start to minIndex - 1 and assign the result to area2.
//  - Recursively call calculateArea for right subarray from minIndex + 1 to end and assign the result to area3.
// 5) Return the maximum of area1, and Max of (area2,area3).
