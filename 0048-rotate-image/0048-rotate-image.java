class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            int left=0;
            int right=n-1;
            while (left<right) {
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
        }
    }
}
// T.C -> O(n^2)
// S.C -> O(1)

// Transpose matrix -> swap elements across main diagonal of matrix i.e row becomes column and column becomes row
// Outer loop, initially i=0
// [0][1]=[1][0], inner loop increment j by 1 and swap i and j
// [0][2]=[2][0], inner loop increment j by 1 and swap i and j
// [0][3]=[3][0], inner loop increment j by 1 and swap i and j
// Now increment i by 1 
// [1][2]=[2][1], inner loop increment j by 1 and swap i and j
// [2][3]=[3][2], inner loop increment j by 1 and swap i and j
// 1,2,3.   1,4,7
// 4,5,6 -> 2,5,8
// 7,8,9.   3,6,9

// Reverse each rows of transposed matrix
// 1,4,7.   7,4,1
// 2,5,8 -> 8,5,2
// 3,6,9.   9,6,3