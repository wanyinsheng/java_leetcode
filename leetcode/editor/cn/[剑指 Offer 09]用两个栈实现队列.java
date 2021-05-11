//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计


//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {

    Deque<Integer> stack1 = null;
    Deque<Integer> stack2 = null;

    public static void main(String[] args) {

    }

    public CQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){//第二个栈为空，找第一个栈
            if (!stack1.isEmpty()) {
                while(!stack1.isEmpty()){//第一个栈不为空，栈一中的数据移动到第二个栈
                    stack2.push(stack1.pop());//实现了第二个栈的数据为第一个栈转置
                }
                return stack2.pop();//所有数据移动到栈二之后，弹出顶端元素
            }else {//第一个栈也为空了，没有数据，返回-1
                return -1;
            }



        }else {
            return stack2.pop();
        }


    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)
