package DataStructBook;

public class StackX_Char {

    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX_Char(int size) {
        maxSize = size;
        stackArray = new char[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(char key) {
        stackArray[++top] = key;
    }

    public int size()         // return size
    {
        return top + 1;
    }

    public char peekN(int n)  // return item at index n
    {
        return stackArray[n];
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println("");
    }
}
