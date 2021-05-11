//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1352 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 先遍历一遍计算链表长度
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //添加一个哑节点
        ListNode dummy=new ListNode(0,head);
        int length=getLength(head);
        ListNode curr=dummy;
        for(int i=1;i<length-n+1;i++){
            curr=curr.next;
        }
        curr.next=curr.next.next;
        ListNode ans=dummy.next;
        return ans;
    }
    private int getLength(ListNode head){
        int length=0;
        while(head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
