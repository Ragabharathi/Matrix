Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

//code
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while(res.size() != m * n) {
            
            //Left to right 
            for(int i = left; i <= right && res.size() != m * n; i++) {
                res.add(matrix[up][i]);
            }
            //top to Down 
            for(int i = up + 1; i <= down && res.size() != m * n; i++) {
                res.add(matrix[i][right]);
            }
            //Right to left 
            for(int i = right - 1; i >= left && res.size() != m * n; i--) {
                res.add(matrix[down][i]);
            }
            //Bottom to top 
            for(int i = down - 1; i >= up + 1 && res.size() != m * n; i--) {
                res.add(matrix[i][left]);
            }
            up++;
            down--;
            left++;
            right--;
        }
        return res;
    }
}
