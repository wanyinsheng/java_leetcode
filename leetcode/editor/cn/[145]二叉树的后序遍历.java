//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 579 👎 0


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

/**
 * 递归法
 */
//class Solution {
//    List<Integer> list = new ArrayList<Integer>();//也可以将list定义在postorderTraversal中，在postOrder中当参数传入
//    public List<Integer> postorderTraversal(TreeNode root) {
//        if(root==null)
//            return list;
//        postOrder(root);
//        return list;
//    }
//    private void postOrder(TreeNode root){
//        if(root==null)
//            return;
//        postOrder(root.left);
//        postOrder(root.right);
//        list.add(root.val);
//    }
//}

/**
 * 迭代法
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)
            return list;
        //定义一个栈
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        TreeNode prev = null;
        while(node!=null||!stack.isEmpty()){//栈不为空或节点不为空
            while(node!=null){
                //访问左子树一直到左节点
                stack.push(node);
                node=node.left;
            }
            //判断栈顶元素
            node = stack.peek();
            //右子树为空node.right == null
            //右子树已经访问过了node.right == prev(prev记录的是上次访的节点)
            if(node.right==null||node.right==prev){
                //保存根节点，并出栈
                stack.pop();
                list.add(node.val);
                //记录prev，表示以当前prev为根的子树已经访问过了
                prev=node;
                //node置null就不会再次访问以node为根节点的左右子树
                node=null;
            }else{
                //访问右子树
                node=node.right;
            }

        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
