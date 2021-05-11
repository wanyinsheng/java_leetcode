//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 860 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        //先将根节点入队列
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<Integer>();
            //先要计算队列大小（该层的个数），然后对子节点入队列继续迭代
            int currentSize=queue.size();
            for(int i=0;i<currentSize;i++){
                //从队列弹出
                TreeNode node = queue.poll();
                list.add(node.val);
                //然后将左右节点按顺序加入队列
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }//end for
            result.add(list);
        }// end while
        return  result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
