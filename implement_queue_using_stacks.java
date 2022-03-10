import java.util.Stack;

public class implement_queue_using_stacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public implement_queue_using_stacks() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        implement_queue_using_stacks myQueue = new implement_queue_using_stacks();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println("Queue Peek, expected 1: " + myQueue.peek()); // return 1
        System.out.println("Queue Pop, return 1 : " + myQueue.pop()); // return 1, queue is [2]
        System.out.println("Queue is not empty, return false: " + myQueue.empty()); // return false
    }
}
