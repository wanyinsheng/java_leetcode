//使用队列实现栈的下列操作： 
//
// 
// push(x) -- 元素 x 入栈 
// pop() -- 移除栈顶元素 
// top() -- 获取栈顶元素 
// empty() -- 返回栈是否为空 
// 
//
// 注意: 
//
// 
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。 
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
// 
// Related Topics 栈 设计 
// 👍 261 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 可以用两个队列实现
 */
//class MyStack {
//    //初始化队列
//    Queue<Integer> queue1;
//    Queue<Integer> queue2;
//    /** Initialize your data structure here. */
//    public MyStack() {
//        queue1=new LinkedList<Integer>();
//        queue2=new LinkedList<Integer>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        //先插到队列2
//        queue2.offer(x);
//        //从队列一中弹出放入队列2
//        while(!queue1.isEmpty())
//            queue2.offer(queue1.poll());
//        //交换队列一与队列2
//        Queue<Integer> temp=queue1;
//        queue1=queue2;
//        queue2=temp;
//    }
//
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//       return queue1.poll();//直接从队列一的队首出队列
//    }
//
//    /** Get the top element. */
//    public int top() {
//       return queue1.peek();
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//       return queue1.isEmpty();
//    }
//}



/**
 * 可以用一个队列实现
 */
class MyStack {
    //初始化一个队列，类似于循环队列
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue=new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        //入对列前，先获取队列的个数，然后将新元素入队列，前n个元素出队列再重新入队列（循环队列）
        int n=queue.size();
        queue.offer(x);
        for(int i=0;i<n;i++){
            queue.offer(queue.poll());//出对列再进队列
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();//直接出对列
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

