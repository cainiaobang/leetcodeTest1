import java.util.*;

public class Min_Stack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Queue<Integer> queue;
    public Min_Stack() {
        this.stack=new Stack<Integer>();
        this.queue=new PriorityQueue<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        queue.offer(x);
    }

    public void pop() {
        int temp=stack.pop();
        queue.remove(temp);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int temp=queue.peek();
        return temp;
    }

   // public static void main(S)
}
