//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
//
// 请你统计并返回 grid 中 负数 的数目。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//输出：8
//解释：矩阵中共有 8 个负数。
// 
//
// 示例 2： 
//
// 输入：grid = [[3,2],[1,0]]
//输出：0
// 
//
// 示例 3： 
//
// 输入：grid = [[1,-1],[-1,-1]]
//输出：3
// 
//
// 示例 4： 
//
// 输入：grid = [[-1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -100 <= grid[i][j] <= 100 
// 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int index = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {//找出所有的为负数的行
            if (grid[i][0] < 0) {
                index = i;
                break;
            }
            count = (m - index) * n;
        }
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    count += (n - j);
                    break;
                }
            }
        }
        return count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
