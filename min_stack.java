import java.util.ArrayDeque;
import java.util.Deque;


interface MinStack {
    public void push(int x);  // pushes the element onto the stack
    public void pop(); // removes the element on top of the stack
    public int top(); // get the top element of the stack
    public int getMin(); // retrieves the minimum element in the stack
}

public class min_stack implements MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();
    
    public min_stack() {}
    
    @Override
    public void push(int x) {
        stack.addFirst(x);
        if (minStack.isEmpty() || x <= minStack.peekFirst()) {
            minStack.addFirst(x);
        }
    }
    
    @Override
    public void pop() {

        if (stack.peekFirst().equals(minStack.peekFirst())) {
            minStack.removeFirst();
        }
        stack.removeFirst();
    }
    
    @Override
    public int top() {
        return stack.peekFirst();
    }

    @Override
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

class min_stack_2 implements MinStack {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<int[]> minStack = new ArrayDeque<>();

    @Override
    public void push(int x) {
        stack.addFirst(x);

        if (minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.addFirst(new int[] {x, 1});
        } else if (x == minStack.peek()[0]) {
            minStack.peekFirst()[1]++;
        }
        
    }

    @Override
    public void pop() {
        if (stack.peekFirst().equals(minStack.peekFirst()[0])) {
            minStack.peekFirst()[1]--;
        }
        if (minStack.peek()[1] == 0) {
            minStack.removeFirst();
        }
        stack.removeFirst();
    }

    @Override
    public int top() {
        return stack.peekFirst();
    }

    @Override
    public int getMin() {
        return minStack.peekFirst()[0];
    }

    public static void main(String[] args) {
        min_stack_2 minStack = new min_stack_2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3); // return -3
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}

/*
Explanation

Interface Practice: another way to achieve abstraction in Java. To access the interface method, uses "implements" keyword. It cannot be used to create objects
It does not have a body, on implementation of an interface, you must override all of its method. 

Why Interface?
To achieve security - hide certain details and only show the important details of an object
Java does not support multiple inheritance. However, it can be achieved with interfaces, because the class can implement multiple interfaces. To implement multiple interfaces, separate them with a comma
class DemoClass implements FirstInterface, SecondInterface {}

For Min Stack, use two stacks to complete the problem. One is a normal stack and the other is our min stack. When we push a new element to the list
we have to check if our min stack is empty or the element we want to push is less than or equal to the current element in the list. If either condition is true, then we push it on to the min stack
because we only push an element if it is smaller than the current element on top of the min stack, min stack will always get the smallest element

When we pop an element, if the element on top of the stack is equal to the element on top of the min stack, remove it from the min stack

The problem with this approach is that we can repeatedly push the same element onto the min stack

Time: O(1) for all operation
Space: O(n)
*/