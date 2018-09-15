package DataStructBook;

public class StackX_Char {

    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX_Char(int size){
        maxSize = size;
        stackArray = new char[size];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public void push(char key){
        stackArray[++top] = key;
    }

    public char pop(){
        return stackArray[top--];
    }

    public char peek(){
        return stackArray[top];
    }
}
