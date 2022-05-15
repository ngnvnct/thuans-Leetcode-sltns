import java.util.ArrayDeque;
import java.util.Deque;

public class implement_queue_using_stacks {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public implement_queue_using_stacks() {
        this.stack1 = new ArrayDeque<>();
        this.stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.addFirst(stack1.removeFirst());
        }
        stack1.addFirst(x);

        while (!stack2.isEmpty()) {
            stack1.addFirst(stack2.removeFirst());
        }
    }

    public int pop() {
        return stack1.removeFirst();
    }

    public int peek() {
        return stack1.peekFirst();
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

/*
Explanation
Using Deque but only using Stack property otherwise it would be cheating. 
Stack is First Un Last Out (FILO), and a Queue is First In First Out (FIFO)

Queue is First In First Out, stack is Last In First Out. This means the newest element must be pushed to the bottom of the stack So if a Queue has [1,2] element, and we want to push 3 onto it.
First we have to tranfser 1 and 2 to an auxilaray stack2.  Then the the element at s2 is pop back and push to stack1.

Push: O(n), Pop O(1)
*/