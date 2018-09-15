package DataStructBook;

/**
 *
 */
public class StackX {

    private int maxSize;
    private String []stackArray;
    private int top;

    public StackX(int size){
        maxSize = size;
        stackArray = new String[size];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public void push(String value){
        stackArray[++top] = value;
    }

    public String pop(){
        return stackArray[top--];
    }

    public String peek(){
        return stackArray[top];
    }


}
