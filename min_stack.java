import java.util.ArrayDeque;
import java.util.Deque;

public class min_stack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();
    
    public min_stack() {}
    
    public void push(int x) {
        stack.addFirst(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.addFirst(x);
        }
    }
    
    public void pop() {

        if (stack.peekFirst().equals(minStack.peekFirst())) {
            minStack.removeFirst();
        }
        stack.removeFirst();
    }
    
    public int top() {
        return stack.peekFirst();
    }

    
    public int getMin() {
        return minStack.peekFirst();
    }

    public static void main(String[] args) {
        min_stack minStack = new min_stack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3); // return -3
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
