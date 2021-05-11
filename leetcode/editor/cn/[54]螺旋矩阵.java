//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {


    }

    public List<Integer> spiralOrder(int[][] matrix) {


        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int[] result=new int[(m+1)*(n+1)];
        if (m > n) {
            int index=0;
            //总共转的圈数
            int count = n / 2 + 1;
            for (int index =0 ; index < count; index++) {
                for (int i = index; i < m; j++) {
                   result[index++]=matrix[0][j]
                }
            }
        } else {

        }
        for (int i = 0; i <= n; i++) {


        }


    }
}

