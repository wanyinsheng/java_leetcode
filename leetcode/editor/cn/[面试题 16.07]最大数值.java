//编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。 
// 示例： 
// 输入： a = 1, b = 2
//输出： 2
// 
// Related Topics 位运算 数学 
// 👍 72 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximum(int a, int b) {
        //
        //max(a,b)=(|a-b|+a+b)/2
        long c=a;
        long d=b;
        return  (int)((Math.abs(c-d)+c+d)/2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
