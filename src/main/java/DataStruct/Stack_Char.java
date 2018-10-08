package DataStruct;

public class Stack_Char {

    public char[] stackArray;
    public int maxSize;
    public int top;

    public Stack_Char(int size){
        this.maxSize = size;
        stackArray = new char[size];
        top = -1;
    }

    public int size(){
        return top + 1;
    }

    public boolean push(char ch){
        if(top == maxSize){
            return false;
        }
        stackArray[++top] = ch;
        return true;
    }


    public char peek(){
        if(stackArray == null){
            return ' ';
        }
        return stackArray[top--];
    }

    public char pop(){
        if(stackArray == null){
            return ' ';
        }
        char ch = stackArray[top];
        stackArray[top] = 0;
        top--;
        return ch;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public void displayStack(){
        if(top == 0){
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

}
