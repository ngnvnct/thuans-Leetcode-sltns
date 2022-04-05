import java.util.Random;
import java.util.Stack;

public class sort_stack {

    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int random = rand.nextInt(100);
            input.push(random);
        }
        sort_stack sort = new sort_stack();
        System.out.println("Input stack  " + input);
        System.out.println("Sorted stack " + sort.sortStack(input));
    }
    public Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> res = new Stack<>();

        while(!input.isEmpty()) {
            int currElement = input.pop();

            while (!res.isEmpty() && res.peek() > currElement) {
                input.push(res.pop());
            }
            res.push(currElement);
        }
        return res;
    }
}

/*abstract
Explanation
Input stack  [34, 3, 31, 98, 92, 23]
Output [23, 92, 98]

is 98 > 31, yes
[34,3,31,98]
is 92 > 31, yes
input [34,3,98,92]
Output [23,31]

Next iteration or something
[23,31,92,98]

is 98 > 3, yes
[34, 98, 92, 31, 23]
Output [3]

Next Iteration
Input [34]
Output [3,23,31,92,98]

is 98 > 34, yes
Input [98,92]
Output [ 3,23,31,34]

Next Iteration
Output [3,23,31,34,92,98]

Idea is that have use a result stack, and while the input stack is not empty, pop out the current element
do a while loop to check that the result is not empty, and the Top Element of the Result Stack is bigger than the current element, if yes
pop out the result element and push onto the input stack

Other than that, continue pushing element onto the result

Time: O(n)
Space: O(n)
*/