package MinStack;
import java.util.Deque;
import java.util.ArrayDeque;
/**
 * Created by juntakuo on 11/13/14.
 */
public class Solution {
    public static void main(String args[]) {
        MinStack stack = new MinStack();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(2147483647);
        stack.top();
        stack.getMin();
        stack.push(-2147483648);
        stack.top();
        stack.getMin();
        stack.pop();
        stack.getMin();

    }
    public static class MinStack {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        Deque<Integer> minValue = new ArrayDeque<Integer>();
        public MinStack() {}
        public void push(int x) {
            stack.push(x);
            if (minValue.size() == 0 || x <= minValue.peek()) minValue.push(x);
        }

        public void pop() {
            if (!stack.isEmpty()) {
                int top = stack.pop();
                if (top == minValue.peek()) minValue.pop();
            } else {
                throw new RuntimeException();
            }
        }

        public int top() {
            if (!stack.isEmpty()) return stack.peek();
            else throw new RuntimeException();
        }

        public int getMin() {
            if (!minValue.isEmpty()) return minValue.peek();
            else throw new RuntimeException();
        }
    }
}
