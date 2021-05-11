//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 531 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 使用哈希表实现,或者Set集合也可以实现
 */
//class Solution {
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        Map<Integer,Boolean> map=new HashMap<Integer,Boolean>();
//        for (int i = 0; i <nums.length ; i++) {
//            map.put(nums[i],true);
//        }
//        List<Integer> list=new ArrayList<Integer>();
//        for (int i = 1; i <=nums.length ; i++) {//元素为1-n之间
//            if (!map.containsKey(i))
//                list.add(i);
//        }
//        return list;
//    }
//}


/**
 * 原地修改，不使用额外空间
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {

            // Treat the value as the new index
            int newIndex = Math.abs(nums[i]) - 1;

            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative
            // thus indicating that the number nums[i] has
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;


    }
}


//leetcode submit region end(Prohibit modification and deletion)
