//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 440 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 递归法
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder,inorder,0,preorder.length,0,inorder.length);
    }
    private root build(int[] preOrder,int[] inoOder,int preLeft,int preRight,int inLeft,int inRight){
        TreeNode root = null;
        //前序遍历的第一个节点就是根节点
        if(preorder==null)
            return root;

        int rootVal=preorder[0];
        //查找中序遍历中的根节点
        int pos;//即左子树的大小
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                pos=i;
                break;
            }
        }// end for
        root.left = build(preOrder,inoOder,1,pos, 0,pos);
        root.right = build(preOrder,inoOder,pos+1,preOrder.length,pos+1,inoOder.length);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
