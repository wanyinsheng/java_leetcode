//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 175 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 排序算法，排序之后提取前k个数，时间复杂度是O(nlogn)
 */
//class Solution {
//    public int[] getLeastNumbers(int[] arr, int k) {
//        Arrays.sort(arr);
//        int[] result=new int[k];
//        for(int i=0;i<k;i++)
//            result[i]=arr[i];
//        return result;
//    }
//}

/**
 *快排思想，左边的小于分界值，右边的大于分界值
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result=new int[k];

    }
    private void fun(int[] arr,int left,int right,int k){
        if(right>=left)
            return;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
