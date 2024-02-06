import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Balance {

    private class Stack<Item> {

        private Node first;

        private class Node {
            Item item;
            Node next;
        }

        public void push(Item item) {
            Node old = first;
            first = new Node();
            first.item = item;
            first.next = old;
        }

        public Item pop() {
            Item item = first.item;
            first = first.next;
            return item;
        }

        public boolean isEmpty() {
            return first == null;
        }
    }

    public static void main(String[] args) {
        Balance balance = new Balance();
        Stack<Character> charStack = balance.new Stack<Character>();
        boolean balanced = true;

        while (StdIn.hasNextChar()) {
            Character next = StdIn.readChar();
            switch (next) {
                case '(':
                case '[':
                    charStack.push(next);
                    break;
                case ')':
                    if (charStack.isEmpty() || charStack.pop() != '(') {
                        balanced = false;
                    }
                    break;
                case ']':
                    if (charStack.isEmpty() || charStack.pop() != '[') {
                        balanced = false;
                    }
                    break;
            }

            if (!balanced) {
                break;
            }

        }

        if (balanced && charStack.isEmpty()) {
            StdOut.print(1);
        } else {
            StdOut.print(0);
        }
    }
}
